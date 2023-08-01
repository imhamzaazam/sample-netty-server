plugins {
    kotlin("jvm") version "1.8.21"
    application
}

group = "org.hamza"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral() {
        metadataSources {
            mavenPom() // Allow retrieval of metadata in 'Maven POM' format
            // Other metadata sources can be added if necessary
        }
    }
}

dependencies {
    testImplementation(kotlin("test"))
    // https://mvnrepository.com/artifact/io.netty/netty-all
    implementation("io.netty:netty-all:5.0.0.Alpha1")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
}