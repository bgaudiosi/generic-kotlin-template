plugins {
    alias(libs.plugins.node.gradle)
}

node {
    version = "20.12.2"
    npmVersion = "10.5.0"
    download = true
    nodeProjectDir = file(".")
}

tasks.register<Exec>("buildFrontend") {
    group = "build"
    description = "Build React frontend"
    dependsOn("npmInstall")
    workingDir = file(".")
    commandLine("npm", "run", "build")
}

tasks.register<Exec>("startDev") {
    group = "application"
    description = "Start React development server"
    dependsOn("npmInstall")
    workingDir = file(".")
    commandLine("npm", "start")
}

tasks.register("build") {
    group = "build"
    description = "Build frontend"
    dependsOn("buildFrontend")
}
