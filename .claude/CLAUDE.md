# Spring Boot Kotlin & React Template Repository

## Project Overview
This is a generic Spring Boot Kotlin & React template repository designed to serve as a starting point for new projects. The primary goal is to provide a simple "Hello World" application with a Kotlin backend and React frontend.

**Current Status**: Basic Gradle-generated Kotlin project structure. Needs to be evolved into a Spring Boot + React template.

## Project Structure
```
generic-kotlin-template/
├── .claude/                    # Claude AI context files
├── backend/                    # Spring Boot Kotlin API
│   ├── src/main/kotlin/        # Kotlin source code
│   │   └── org/example/        # Package structure
│   │       ├── Application.kt  # Spring Boot main class
│   │       └── controller/     # REST controllers
│   ├── src/main/resources/     # Application resources
│   │   └── application.properties
│   ├── src/test/kotlin/        # Kotlin test code
│   └── build.gradle.kts        # Backend module build configuration
├── frontend/                   # React TypeScript frontend
│   ├── src/                    # React source code
│   │   ├── App.tsx            # Main React component
│   │   ├── index.tsx          # React entry point
│   │   └── index.css          # Styles
│   ├── public/                 # Static assets
│   │   └── index.html         # HTML template
│   ├── package.json           # NPM dependencies
│   ├── tsconfig.json          # TypeScript configuration
│   └── build.gradle.kts       # Frontend build integration
├── gradle/                     # Gradle wrapper and version catalog
│   └── libs.versions.toml     # Dependency version management
├── build.gradle.kts           # Root build configuration
├── settings.gradle.kts        # Gradle settings
└── gradle.properties          # Gradle properties
```

## Technology Stack

### Current Dependencies
- **Kotlin**: 2.0.20 (JVM target)
- **Java**: 21 (toolchain)
- **Gradle**: 8.11.1 with Kotlin DSL
- **Spring Boot**: 3.2.5 with Kotlin support
- **React**: 18.3.1 with TypeScript
- **Testing**: JUnit Jupiter 5.10.3, Spring Boot Test, React Testing Library
- **Code Quality**: Spotless with ktlint formatting

### Target Stack (✅ Implemented)
- **Backend**: Spring Boot 3.2.5 with Kotlin ✅
- **Frontend**: React 18.3.1 with TypeScript ✅
- **Build Tool**: Gradle with Kotlin DSL ✅
- **Package Manager**: npm for frontend dependencies ✅

## Development Conventions

### Code Style
- **Kotlin**: Uses ktlint via Spotless plugin for formatting
- **Gradle**: Kotlin DSL preferred over Groovy
- **Package Structure**: Currently `org.example.*` (should be updated for template)

### Build Configuration
- **Gradle Properties**: Configuration cache, parallel builds, and caching enabled
- **Version Catalog**: Uses `gradle/libs.versions.toml` for dependency management
- **Java Toolchain**: Java 21 specified for consistent builds across environments

### Testing
- **Framework**: JUnit Jupiter
- **Assertions**: Google Truth library
- **Structure**: Standard Maven/Gradle directory layout (`src/test/kotlin`)

## Project Goals
1. **Simple Setup**: Minimal configuration to get started
2. **Best Practices**: Modern Kotlin and React patterns
3. **Developer Experience**: Fast builds, good tooling, clear structure
4. **Template Ready**: Easy to clone and customize for new projects

## Current Implementation
The project is now a fully functional multimodule Spring Boot Kotlin + React TypeScript template:

### Backend Module
- **Spring Boot Application**: Main application class with embedded Tomcat
- **REST API**: `/api/hello` endpoint returning JSON response
- **Testing**: Controller tests using MockMvc and Spring Boot Test
- **Configuration**: application.properties with server configuration

### Frontend Module  
- **React Application**: TypeScript-based React app
- **API Integration**: Fetches data from backend `/api/hello` endpoint
- **Styling**: Clean, responsive CSS with loading and error states
- **Development**: Integrated with Gradle build system
- **Proxy Configuration**: Development proxy to backend server

### Build System
- **Multimodule Gradle**: Root project coordinates backend and frontend builds
- **Unified Tasks**: `buildAll`, `testAll`, and `startDev` tasks for full-stack development
- **Code Quality**: Spotless formatting for Kotlin code
- **Development Workflow**: Separate dev servers for frontend and backend

## Next Steps for Template Development
The template is now complete with the following features:
1. ✅ Spring Boot dependencies and configuration
2. ✅ REST API endpoints
3. ✅ React frontend with build integration  
4. ✅ Development and production build configuration
5. ⏳ Docker support (optional future enhancement)
6. ✅ Updated documentation and README

## Usage Instructions

### Development
Start backend and frontend separately for development:
```bash
# Terminal 1 - Start backend (http://localhost:8080)
./gradlew :backend:bootRun

# Terminal 2 - Start frontend (http://localhost:3000)  
./gradlew :frontend:startDev
```

### Production Build
Build everything for production:
```bash
./gradlew buildAll
```

### Testing
Run all tests:
```bash
./gradlew testAll
```

## File Patterns to Follow
- **Kotlin files**: Use `.kt` extension, follow ktlint formatting
- **Configuration**: Prefer Kotlin DSL (`.gradle.kts`) over Groovy
- **Resources**: Standard Maven directory structure
- **Documentation**: Use Markdown for all documentation files

## Dependencies Management
All dependencies are managed through the version catalog in `gradle/libs.versions.toml`. When adding new dependencies:
1. Add version to `[versions]` section
2. Add library reference to `[libraries]` section
3. Reference using `libs.` prefix in build files
