package com.example.data

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object StudentTable : Table() {
    val id: Column<Int> = integer("id")
    val name: Column<String> = varchar("name", length = 252)
    val age: Column<Int> = integer("age")
}
