package com.example.data

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object StudentInfoTable :Table(){
    val studentId:Column<Int> = integer("StudentId").references(StudentTable.id)
    val city:Column<String> = varchar("City",252)
    val pinCode:Column<Int> = integer("Pincode")
}