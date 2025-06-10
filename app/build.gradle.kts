plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
    alias(libs.plugins.liquibase.gradle.plugin)
}

repositories {
    mavenCentral()
}

dependencies {
    liquibaseRuntime(libs.liquibase.core)
    liquibaseRuntime(libs.picocli)
    liquibaseRuntime(libs.snakeyaml)
    liquibaseRuntime(libs.postgresql)

    implementation(libs.spring.boot.starter.web)
    implementation(libs.postgresql)

    testImplementation(libs.spring.boot.starter.test)
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.truth)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

springBoot {
    mainClass.set("org.example.ApplicationKt")
}

liquibase {
    activities {
        register("main") {
            this.arguments = mapOf(
                "changelogFile" to "app/src/main/resources/db/changelog/db.changelog-master.yaml",
                "url" to (project.findProperty("postgres.url") as? String
                    ?: "jdbc:postgresql://localhost:54320/my_db"),
                "username" to (project.findProperty("postgres.user") as? String ?: "user"),
                "password" to (project.findProperty("postgres.password") as? String ?: "pass"),
                "logLevel" to "info"
            )
        }
    }
    runList = "main"
}