package com.example.database

import com.example.dao.BookDao
import com.example.data.Book
import com.example.data.BookTable
import com.example.data.StudentTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select

class BookMethodCall:BookDao {
    override suspend fun insertBook(userId: Int, bookName: String) :Book? {
        return if (findingPresence(userId)){
            DatabaseFactory.dbQuery {
                BookTable.insert {
                    it[studentId] = userId
                    it[BookTable.bookName] = bookName
                }.resultedValues?.singleOrNull().let {
                    rowToBook(it)
                }
            }
        } else null
    }

    override suspend fun gettingBook(userId: Int): List<Book>? {
        return if(findingPresence(userId)){
            DatabaseFactory.dbQuery {
                BookTable.select { BookTable.studentId.eq(userId) }.map {row ->
                    Book(row[BookTable.studentId], row[BookTable.bookName])
                }
            }
        } else null
    }

    private fun rowToBook(row:ResultRow?):Book?{
        return if(row==null) null
        else Book(
            id = row[BookTable.studentId],
            bookName = row[BookTable.bookName]
        )
    }
}

suspend fun findingPresence(userId:Int):Boolean{
    return DatabaseFactory.dbQuery { StudentTable.select { StudentTable.id.eq(userId)}.count()>0}

}