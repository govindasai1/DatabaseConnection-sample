package com.example.database

import com.example.dao.StudentInfoDao
import com.example.data.StudentInfo
import com.example.data.StudentInfoTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll

class StudentInfoCall :StudentInfoDao{
    override suspend fun insert(id: Int, city: String, pinCode: Int): StudentInfo? {
        return if(findingPresence(id)) DatabaseFactory.dbQuery {
            StudentInfoTable.insert {
                it[studentId] = id
                it[StudentInfoTable.city] = city
                it[StudentInfoTable.pinCode] = pinCode
            }.resultedValues?.singleOrNull().let { rowToStudentInfo(it) }
        }
        else null
    }

    override suspend fun gettingAll(): List<StudentInfo> {
       return DatabaseFactory.dbQuery { StudentInfoTable.selectAll() }.mapNotNull { rowToStudentInfo(it) }
    }

    override suspend fun gettingStudent(id:Int): StudentInfo? {
        return DatabaseFactory.dbQuery { StudentInfoTable.select { StudentInfoTable.studentId.eq(id) }.map { rowToStudentInfo(it) }.singleOrNull() }
    }


    private fun rowToStudentInfo(row:ResultRow?):StudentInfo?{
        return if(row==null) null
        else{
            StudentInfo(id = row[StudentInfoTable.studentId],
                city = row[StudentInfoTable.city],
                pinCode = row[StudentInfoTable.pinCode]
                )
        }

    }

}
