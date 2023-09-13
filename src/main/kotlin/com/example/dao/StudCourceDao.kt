package com.example.dao

import com.example.data.Register

interface StudCourceDao {
    suspend fun register(studentId:Int,courceId:Int):String
    suspend fun studentCources(id:Int):List<Register?>
    suspend fun courceStudent(id:Int):List<Register?>
}