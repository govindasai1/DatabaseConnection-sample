package com.example.database

import com.example.dao.CourceDao
import com.example.data.Cource
import com.example.data.CourceTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll

class CourceMethodCall:CourceDao {
    override suspend fun insert(id: Int, name: String): Cource? {
       return DatabaseFactory.dbQuery {
            CourceTable.insert {
                it[courceId] = id
                it[courceName] = name
            }.resultedValues?.singleOrNull().let { rowToCource(it) }
        }
    }

    override suspend fun gettingall(): List<Cource> {
        return DatabaseFactory.dbQuery {
            CourceTable.selectAll().mapNotNull { rowToCource(it) }
        }
    }
    private fun rowToCource(row: ResultRow?): Cource?{
        return if (row==null) null
        else Cource(id=row[CourceTable.courceId], courceName = row[CourceTable.courceName])
    }
}