package com.example.data

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object BookTable :Table(){
    val studentId = integer("studentId").references(StudentTable.id)
    val bookName:Column<String> = varchar("bookName",252)
}