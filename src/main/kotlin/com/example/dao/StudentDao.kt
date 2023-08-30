package com.example.dao

import com.example.data.Student

interface StudentDao  {
    suspend fun insert(id:String,name:String,age:Int):Student?
    suspend fun getAllStudents():List<Student>?
    suspend fun getStudentById(id:String):Student?
    suspend fun deleteById(id: String):String
    suspend fun update(id:String,name:String,age: Int):Int
}