package com.example.routes

import com.example.data.Book
import com.example.database.BookMethodCall
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

val Object = BookMethodCall()
fun Route.routingBooks(){
    route("/book"){
        post {
            val post = call.receive<Book>()
            call.respond(Object.insertBook(post.id,post.bookName)?:"NOT INSERTED")
        }

        get("{id?}"){
            val id = call.parameters["id"]?:return@get call.respond("ENTER ID")
            call.respond(Object.gettingBook(id.toInt())?:"STUDENT ID NOT PRESENT")
        }
    }
}