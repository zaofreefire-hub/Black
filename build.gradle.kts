import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.22"
}

group = "black23.cloudstream"
version = "1.0.0"

repositories {
    mavenCentral()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.register<Jar>("makePlugin") {
    archiveBaseName.set("black23")
    archiveVersion.set(project.version.toString())
    archiveExtension.set("cs3")

    from(sourceSets.main.get().output)
    destinationDirectory.set(layout.buildDirectory.dir("plugins"))
}
