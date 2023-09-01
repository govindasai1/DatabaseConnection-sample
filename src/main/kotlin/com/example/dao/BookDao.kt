package com.example.dao

import com.example.data.Book

interface BookDao {
    suspend fun insertBook(userId:Int,bookName:String): Book?

    suspend fun gettingBook(userId: Int):List<Book>?
}