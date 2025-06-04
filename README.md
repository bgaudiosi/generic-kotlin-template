# Generic Kotlin Template

A multimodule Spring Boot Kotlin + React TypeScript template repository for quickly starting new full-stack projects.

## Project Structure

```
generic-kotlin-template/
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

- **Backend**: Spring Boot 3.2.5 with Kotlin 2.0.20
- **Frontend**: React 18.3.1 with TypeScript
- **Build Tool**: Gradle 8.11.1 with Kotlin DSL
- **Java**: 21 (toolchain)
- **Package Manager**: npm for frontend dependencies
- **Testing**: JUnit Jupiter, Spring Boot Test, React Testing Library
- **Code Quality**: Spotless with ktlint formatting

## Quick Start

### Prerequisites
- Java 21
- Node.js 20+ (automatically downloaded by Gradle)

### Development

1. **Clone and setup:**
   ```bash
   git clone <your-repo-url>
   cd generic-kotlin-template
   ```

2. **Start backend (Terminal 1):**
   ```bash
   ./gradlew :backend:bootRun
   ```
   Backend will be available at http://localhost:8080

3. **Start frontend (Terminal 2):**
   ```bash
   ./gradlew :frontend:startDev
   ```
   Frontend will be available at http://localhost:3000

The frontend automatically proxies API calls to the backend during development.

### Available Endpoints

- **Frontend**: http://localhost:3000
- **Backend API**: http://localhost:8080/api/hello

### Build Commands

```bash
# Build everything
./gradlew buildAll

# Build individual modules
./gradlew :backend:build
./gradlew :frontend:build

# Run all tests
./gradlew testAll

# Run individual tests
./gradlew :backend:test
./gradlew :frontend:testFrontend

# Format code
./gradlew :backend:spotlessApply
```

## Project Features

### Backend
- ✅ Spring Boot with Kotlin
- ✅ REST API with JSON responses
- ✅ Application configuration
- ✅ Controller tests with MockMvc
- ✅ Code formatting with Spotless/ktlint

### Frontend
- ✅ React with TypeScript
- ✅ API integration with backend
- ✅ Responsive CSS styling
- ✅ Error handling and loading states
- ✅ Development proxy configuration

### Build System
- ✅ Multimodule Gradle project
- ✅ Unified build tasks
- ✅ Version catalog for dependency management
- ✅ Node.js integration for frontend
- ✅ Code quality checks


## Customization

### Package Structure
1. Update package name from `org.example` in:
   - `backend/src/main/kotlin/org/example/`
   - `backend/src/test/kotlin/org/example/`
   - All Kotlin files

### Application Name
1. Update `spring.application.name` in `backend/src/main/resources/application.properties`
2. Update `name` in `frontend/package.json`
3. Update `rootProject.name` in `settings.gradle.kts`

### Dependencies
Add new dependencies to `gradle/libs.versions.toml`:
```toml
[versions]
new-library = "1.0.0"

[libraries]
new-library = { module = "com.example:new-library", version.ref = "new-library" }
```

Then reference in module build files:
```kotlin
dependencies {
    implementation(libs.new.library)
}
```

## Development Workflow

1. **API Development**: Add endpoints in `backend/src/main/kotlin/org/example/controller/`
2. **Frontend Development**: Update `frontend/src/App.tsx` to consume new APIs
3. **Testing**: Add tests in respective `src/test/` directories
4. **Building**: Use `./gradlew buildAll` for production builds

## Production Deployment

The backend can serve the frontend static files. Build steps:

1. Build frontend: `./gradlew :frontend:build`
2. Copy frontend build to backend resources (manual step for now)
3. Build backend: `./gradlew :backend:build`
4. Deploy the backend JAR file

## Contributing

1. Run `./gradlew :backend:spotlessApply` before committing Kotlin code
2. Ensure all tests pass: `./gradlew testAll`
3. Verify builds work: `./gradlew buildAll`

## License

This template is provided as-is for creating new projects.
