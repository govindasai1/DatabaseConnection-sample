package com.example.database

import com.example.dao.StudCourceDao
import com.example.data.CourceTable
import com.example.data.Register
import com.example.data.StudCourceTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select

class StudCourceCall:StudCourceDao {
    override suspend fun register(studentId: Int, courceId: Int):String {
        return if (findingPresence(studentId) && findingPresenceCource(courceId)){
             DatabaseFactory.dbQuery {
                StudCourceTable.insert {
                    it[studId] = studentId
                    it[CourceId] = courceId
                }.resultedValues?.singleOrNull()
            }
            "STUDENT ID $studentId REGISTERED"
        } else {
            "STUDENT ID $studentId NOT PRESENT IN STUDENTS"
        }

    }

    override suspend fun studentCources(id: Int): List<Register?> {
        return DatabaseFactory.dbQuery { StudCourceTable.select {
            StudCourceTable.studId.eq(id)
        }.map {  rowToResistor(it)} }
    }

    override suspend fun courceStudent(id: Int): List<Register?> {
        return DatabaseFactory.dbQuery { StudCourceTable.select {
            StudCourceTable.CourceId.eq(id)
        }.map { rowToResistor(it) } }
    }

    private suspend fun findingPresenceCource(userId:Int):Boolean{
        return DatabaseFactory.dbQuery { CourceTable.select { CourceTable.courceId.eq(userId)}.count()>0}
    }
    private fun rowToResistor(row:ResultRow?):Register?{
        return if(row==null) null
        else Register(studentId = row[StudCourceTable.studId], courceId = row[StudCourceTable.CourceId])
    }
}