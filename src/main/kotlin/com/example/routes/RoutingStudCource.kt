package com.example.routes

import com.example.data.Register
import com.example.database.StudCourceCall
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

val Obje = StudCourceCall()
fun Route.studCource(){
    route("/register"){
        post {
            val register = call.receive<Register>()
            call.respond(Obje.register(register.studentId,register.courceId))
        }
        get ("/studentCourses/{id?}"){
            val id = call.parameters["id"]?:return@get call.respond("ENTER ID")
            call.respond(Obje.studentCources(id.toInt()))
        }
        get ("/courceStudent/{id?}"){
            val id = call.parameters["id"]?:return@get call.respond("ENTER ID")
            call.respond(Obje.courceStudent(id.toInt()))
        }

    }
}