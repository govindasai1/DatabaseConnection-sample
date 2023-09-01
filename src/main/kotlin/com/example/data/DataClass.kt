package com.example.data

import kotlinx.serialization.Serializable

@Serializable
data class Student(val id: Int, val name: String, val age: Int)
@Serializable
data  class Book(val id:Int,val bookName:String)

@Serializable
data class StudentInfo(val id:Int,val city:String,val pinCode:Int)