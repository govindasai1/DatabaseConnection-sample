package com.example.database

import com.example.data.*
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    fun init() {
        val url = "jdbc:postgresql://localhost:8080/sample"
        val driver = "org.postgresql.Driver"
        val user = "postgres"
        val password = "root"
        Database.connect(url, driver, user, password)

        transaction {
            SchemaUtils.createMissingTablesAndColumns(StudentTable,BookTable,StudentInfoTable,CourceTable,StudCourceTable)
        }
    }

    suspend fun <T> dbQuery(block:  () ->T): T =
        newSuspendedTransaction(Dispatchers.IO) {
            block()
        }

}