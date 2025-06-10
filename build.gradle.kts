plugins {
    alias(libs.plugins.spotless) apply false
}

allprojects {
    group = "org.example"
    version = "1.0.0"
}

// Configure Spotless for all Kotlin projects
subprojects {
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

// Task to start both app and frontend in development
tasks.register("startDev") {
    group = "application"
    description = "Start both app and frontend in development mode"
    doLast {
        println("To start development:")
        println("1. Run './gradlew :app:bootRun' in one terminal")
        println("2. Run './gradlew :frontend:startDev' in another terminal")
        println("3. Frontend will be available at http://localhost:3000")
        println("4. App API will be available at http://localhost:8080")
    }
}
