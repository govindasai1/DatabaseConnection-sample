package com.example.data

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object StudCourceTable:Table() {
    val studId:Column<Int> = integer("StudentId").references(StudentTable.id)
    val CourceId:Column<Int> = integer("CourceId").references(CourceTable.courceId)
}