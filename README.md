# Clean Architecture Android App Using MVI

A sample Android application showcasing Clean Architecture principles using Jetpack Compose and MVI (Model-View-Intent) pattern. The app demonstrates how to fetch and display user data from a REST API while following best practices in modern Android development.

## Features
- Clean Architecture implementation with clear separation of concerns
- MVI (Model-View-Intent) pattern for predictable state management
- Jetpack Compose for modern UI development
- Coroutines & Flow for asynchronous operations
- Dependency Injection using Koin
- Unit tests and UI tests
- REST API integration using Ktor

## Architecture
The application follows Clean Architecture principles and is divided into three main layers:

### Presentation Layer
- **UI**: Compose screens and components
- **ViewModels**: Handle UI logic and state management
- **States**: Immutable state objects representing UI state
- **Intents**: User actions that can modify the state

### Domain Layer
- **Use Cases**: Business logic and data operations
- **Repositories**: Abstract definitions of data operations
- **Models**: Business logic models

### Data Layer
- **Repository Implementations**: Concrete implementations of repositories
- **Remote Data Source**: Ktor client services
- **DTOs**: Data transfer objects for network responses

## Tech Stack
- **Jetpack Compose**: Modern UI toolkit
- **Kotlin Coroutines & Flow**: Asynchronous programming
- **Koin**: Lightweight dependency injection
- **Ktor**: Kotlin-first HTTP client
- **Kotlin Serialization**: JSON parsing
- **JUnit**: Unit testing
- **Mockk**: Mocking for tests
- **Compose Testing**: UI testing

## Getting Started
### Prerequisites
- Android Studio Arctic Fox or later
- JDK 11 or later
- Android SDK 21 or later

### Installation
1. Clone the repository:
```bash
git clone https://github.com/alicse233/CleanArchitectureMVICompose.git
```

2. Open the project in Android Studio

3. Run the app on an emulator or physical device

## Project Structure
```
app/
├── src/
│   ├── main/
│   │   ├── java/app/mvicompose
│   │   │   ├── di/
│   │   │   │   └── AppModule.kt
│   │   │   ├── domain/
│   │   │   │   ├── model/
│   │   │   │   ├── repository/
│   │   │   │   └── usecase/
│   │   │   ├── data/
│   │   │   │   ├── remote/
│   │   │   │   │   └── UserApi.kt
│   │   │   │   ├── repository/
│   │   │   │   
│   │   │   └── presentation/
│   │   │       ├── ui/
│   │   │       ├── home/
│   │   │     
│   │   └── res/
│   └── test/
└── build.gradle
```

## Contributing
1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details

## Acknowledgments
- [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) by Robert C. Martin
- [Guide to app architecture](https://developer.android.com/jetpack/guide) by Android
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Koin](https://insert-koin.io/)
- [Ktor](https://ktor.io/)
