plugins {
    id("org.jetbrains.intellij.platform") version "2.5.0"
    kotlin("jvm") version "2.1.20"
    java
}

group = "dev.jstanger"
version = "0.7.2"

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        intellijIdeaCommunity("2025.1")
    }

    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks {
    patchPluginXml {
        changeNotes.set(
            """
            Update to latest IntelliJ version.
            """.trimIndent()
        )
    }
}
tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

sourceSets["main"].java.srcDirs("src/main/gen")