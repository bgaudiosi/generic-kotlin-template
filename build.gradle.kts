plugins {
    alias(libs.plugins.spotless) apply false
}

allprojects {
    group = "org.example"
    version = "1.0.0"
}

// Configure Spotless for all Kotlin projects
subprojects {
    if (name == "backend") {
        apply(plugin = "com.diffplug.spotless")
        
        configure<com.diffplug.gradle.spotless.SpotlessExtension> {
            kotlin {
                ktlint()
            }
            kotlinGradle {
                target("*.gradle.kts")
                ktlint()
            }
        }
    }
}

// Task to run both backend and frontend builds
tasks.register("buildAll") {
    group = "build"
    description = "Build both backend and frontend"
    dependsOn(":backend:build", ":frontend:buildFrontend")
}

// Task to run all tests
tasks.register("testAll") {
    group = "verification"
    description = "Run all tests for backend and frontend"
    dependsOn(":backend:test", ":frontend:testFrontend")
}

// Task to start both backend and frontend in development
tasks.register("startDev") {
    group = "application"
    description = "Start both backend and frontend in development mode"
    doLast {
        println("To start development:")
        println("1. Run './gradlew :backend:bootRun' in one terminal")
        println("2. Run './gradlew :frontend:startDev' in another terminal")
        println("3. Frontend will be available at http://localhost:3000")
        println("4. Backend API will be available at http://localhost:8080")
    }
}
