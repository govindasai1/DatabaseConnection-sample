package com.example

import com.example.database.DatabaseFactory
import com.example.plugins.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*

fun main() {
    embeddedServer(Netty, port = 8085, host = "127.0.0.7", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    DatabaseFactory.init()
    configureSerialization()
    configureRouting()

}
