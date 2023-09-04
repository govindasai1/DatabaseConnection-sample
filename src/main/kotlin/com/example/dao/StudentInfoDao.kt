package com.example.dao

import com.example.data.StudentInfo

interface StudentInfoDao {
    suspend fun insert(id:Int,city:String,pinCode:Int):StudentInfo?
    suspend fun gettingAll():List<StudentInfo>
    suspend fun gettingStudent(id:Int):StudentInfo?
}