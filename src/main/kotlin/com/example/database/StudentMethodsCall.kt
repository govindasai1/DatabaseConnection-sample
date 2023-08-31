package com.example.database

import com.example.dao.StudentDao
import com.example.data.Student
import com.example.data.StudentTable
import com.example.routes.Obj
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class StudentMethodsCall:StudentDao {


    override suspend fun insert(id: Int, name: String, age: Int): Student? {
       return DatabaseFactory.dbQuery {
           val statement= StudentTable.insert {
                it[StudentTable.id]=id
                it [StudentTable.age]=age
                it [StudentTable.name]=name
            }
            statement.resultedValues?.singleOrNull()?.let {
                rowToStudent(it)
            }
        }

    }

    override suspend fun getAllStudents(): List<Student> {
        var listOfStudents: List<Student> = DatabaseFactory.dbQuery {
            StudentTable.selectAll().mapNotNull {
                rowToStudent(it)
            }
        }
        return listOfStudents
    }

    override suspend fun getStudentById(id: Int): Student? {
       var x= DatabaseFactory.dbQuery {
            StudentTable.select {StudentTable.id.eq(id)
            }.map {
                rowToStudent(it)
            }.singleOrNull()
        }
        return x
    }

    override suspend fun deleteById(id: Int): String {
        var x=DatabaseFactory.dbQuery {
            StudentTable.deleteWhere {
                this.id.eq(id) }
        }
        return if(x==0) "not deleted"
        else "deleted"

    }

    override suspend fun update(id: Int, name: String, age: Int): Int {
       return DatabaseFactory.dbQuery {
            StudentTable.update({StudentTable.id.eq(id)}){
                it[StudentTable.name] = name
                it[StudentTable.age] = age
            }
        }
    }


    private fun rowToStudent(row:ResultRow?): Student? {
        if(row==null) return null
        return Student(
            id= row[StudentTable.id],
            name=row[StudentTable.name],
            age=row[StudentTable.age]

        )

    }
}
