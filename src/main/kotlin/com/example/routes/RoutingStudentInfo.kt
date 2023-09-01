package com.example.routes

import com.example.data.StudentInfo
import com.example.database.StudentInfoCall
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
val Object1 = StudentInfoCall()
fun Route.studentInfoRouting(){
    route("/studentInfo"){
        post {
           val studentInfo= call.receive<StudentInfo>()
            call.respond(Object1.insert(studentInfo.id,studentInfo.city,studentInfo.pinCode)?:"INSERT STUDENT INFO")
        }
        get{
            call.respond(Object1.getingAll())
        }
        get("{id?}"){
            val id = call.parameters["id"]?:return@get call.respond("ENTER ID")
            call.respond(Object1.getingStudent(id.toInt())?:"ID NOT FOUND")


        }
    }
}