plugins {
    id("org.jetbrains.intellij") version "1.13.3"
    kotlin("jvm") version "1.7.20"
    java
}

group = "dev.jstanger"
version = "0.5.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version.set("2023.1")
}
tasks {
    patchPluginXml {
        changeNotes.set(
            """
            - Add support for Corn v0.7 (spread operator)
            - Add validation around inputs, key-chaining, and spreading
            - Fix several parser-related bugs
            """.trimIndent()
        )
    }
}
tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

sourceSets["main"].java.srcDirs("src/main/gen")