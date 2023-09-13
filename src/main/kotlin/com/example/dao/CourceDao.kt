package com.example.dao

import com.example.data.Cource

interface CourceDao {
    suspend fun insert(id:Int,name:String):Cource?
    suspend fun gettingall():List<Cource>
}