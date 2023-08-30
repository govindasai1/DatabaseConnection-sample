
val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val exposed_version: String by project
val postgeqsql_version: String by project
val Hikari_version: String by project

plugins {
    kotlin("jvm") version "1.9.0"
    id("io.ktor.plugin") version "2.3.3"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.0"
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("com.example.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-content-negotiation-jvm")
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
    implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.postgresql:postgresql:$postgeqsql_version")
    implementation("com.zaxxer:HikariCP:$Hikari_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
//    implementation (com.fasterxml.jackson.module:jackson-module-kotlin:2.12.1)

}
