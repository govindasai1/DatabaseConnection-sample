package com.example.dao

import com.example.data.Student

interface StudentDao  {
    suspend fun insert(id:Int,name:String,age:Int):Student?
    suspend fun getAllStudents():List<Student>?
    suspend fun getStudentById(id:Int):Student?
    suspend fun deleteById(id: Int):String
    suspend fun update(id:Int,name:String,age: Int):Int
}