package com.example.data

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

class StudentTable : Table() {
    val id: Column<String> = varchar("id", length = 252)
    val name: Column<String> = varchar("name", length = 252)
    val age: Column<Int> = integer("age")
}