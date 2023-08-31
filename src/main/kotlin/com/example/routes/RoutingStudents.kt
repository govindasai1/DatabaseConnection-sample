package com.example.routes
import com.example.data.Student
import com.example.database.StudentMethodsCall
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
val Obj=StudentMethodsCall()
fun Route.studentRouting(){
    route("/student"){


        get {
           call.respond(Obj.getAllStudents())
        }


        get("{id?}"){
            val id = call.parameters["id"]?:return@get call.respondText("ID CANT BE NULL", status = HttpStatusCode.BadRequest)
            call.respond(Obj.getStudentById(id.toInt()) ?:"NO STUDENT WITH $id PRESENT")
        }


        post {
            val student = call.receive<Student>()
            call.respond(Obj.insert(student.id,student.name,student.age)?:"not inserted")
        }

        put {
            val student = call.receive<Student>()
            val result = Obj.update(student.id,student.name,student.age)
            if (result==1) call.respond("ID UPDATED")
            else call.respond("${student.id} WITH STUDENT NOT PRESENT")
        }


        delete("{id?}") {
            val id =call.parameters["id"]?:return@delete call.respondText("ENTER ID", status = HttpStatusCode.BadRequest)
            call.respond(Obj.deleteById(id.toInt()))
        }

    }
}