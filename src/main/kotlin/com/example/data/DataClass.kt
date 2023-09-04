package com.example.data

import kotlinx.serialization.Serializable

@Serializable
data class Student(val id: Int, val name: String, val age: Int)
@Serializable
data  class Book(val id:Int,val bookName:String)
@Serializable
data class StudentInfo(val id:Int,val city:String,val pinCode:Int)
@Serializable
data class Cource(val id:Int,val courceName:String)
@Serializable
data class Register(val studentId:Int,val courceId:Int)
