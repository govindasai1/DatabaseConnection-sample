package com.example.routes

import com.example.data.Cource
import com.example.database.CourceMethodCall
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

val Object2 = CourceMethodCall()
fun Route.courceRouting(){
    route("/cource"){
        get {
            call.respond(Object2.gettingall())
        }

        post {
           val cource =  call.receive<Cource>()
            call.respond(Object2.insert(cource.id,cource.courceName)?:"Enter cource")
        }
    }
}
