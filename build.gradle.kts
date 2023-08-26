import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    java
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    mavenLocal()
    mavenCentral()
    maven { url = uri("https://repo.papermc.io/repository/maven-public/") }
    maven { url = uri("https://repo.codemc.io/repository/maven-public/") }
    maven { url = uri("https://repo.dmulloy2.net/repository/public/") }
    maven { url = uri("https://repo.extendedclip.com/content/repositories/placeholderapi/") }
    maven { url = uri("https://maven.enginehub.org/repo/") }
    maven { url = uri("https://repo.aikar.co/content/groups/aikar/") }
    maven { url = uri("https://jitpack.io/") }
}

dependencies {
    implementation("com.github.stefvanschie.inventoryframework:IF:0.10.11")
    implementation("com.h2database:h2:2.2.220")
    implementation("co.aikar:acf-paper:0.5.1-SNAPSHOT")
    compileOnly("com.github.PestoNotPasta:LunarClientAPI:1.0.0")
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
    compileOnly("de.tr7zw:item-nbt-api-plugin:2.11.3")
    compileOnly("com.comphenix.protocol:ProtocolLib:5.0.0-SNAPSHOT")
    compileOnly("me.clip:placeholderapi:2.11.3")
    compileOnly("commons-io:commons-io:2.11.0")
    compileOnly("me.filoghost.holographicdisplays:holographicdisplays-api:3.0.0")

}

group = "io.github.devpesto"
version = "1.0-SNAPSHOT"
description = "EventWarGame"


java {
    toolchain.languageVersion = JavaLanguageVersion.of(17)
}

tasks {

    withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.compilerArgs.add("-parameters")
        options.forkOptions.executable = "javac"
    }

    withType<ShadowJar> {
        mergeServiceFiles()

    }

    build {
        dependsOn(shadowJar)
    }

}