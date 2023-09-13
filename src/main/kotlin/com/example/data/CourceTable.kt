package com.example.data

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object CourceTable :Table(){
    val courceId:Column<Int> = integer("CourceId")
    val courceName:Column<String> = varchar("CourceName",252)
    override val primaryKey = PrimaryKey(courceId,name = "courceId")
}
