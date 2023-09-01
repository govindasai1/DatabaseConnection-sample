package com.example.plugins

import com.example.routes.routingBooks
import com.example.routes.studentInfoRouting
import com.example.routes.studentRouting
import io.ktor.server.application.*
import io.ktor.server.routing.*


fun Application.configureRouting() {
    routing {
        studentRouting()
        routingBooks()
        studentInfoRouting()
    }
}
