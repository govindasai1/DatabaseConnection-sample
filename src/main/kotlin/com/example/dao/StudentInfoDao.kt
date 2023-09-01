package com.example.dao

import com.example.data.StudentInfo

interface StudentInfoDao {
    suspend fun insert(id:Int,city:String,pinCode:Int):StudentInfo?
    suspend fun getingAll():List<StudentInfo>
    suspend fun getingStudent(id:Int):StudentInfo?
}