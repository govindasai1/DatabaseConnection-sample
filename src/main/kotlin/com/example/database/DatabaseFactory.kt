package com.example.database

import com.example.data.Student
import com.example.data.StudentTable
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction
val StudentTable = StudentTable()

object DatabaseFactory {
    fun init() {
        val url = "jdbc:postgresql://localhost:8080/test"
        val driver = "org.postgresql.Driver"
        val user = "postgres"
        val password = "root"
        Database.connect(url, driver, user, password)

        transaction {
            SchemaUtils.createMissingTablesAndColumns(StudentTable)
        }
    }

    suspend fun <T> dbQuery(block:  () ->T): T =
        newSuspendedTransaction(Dispatchers.IO) {
            block() }

}