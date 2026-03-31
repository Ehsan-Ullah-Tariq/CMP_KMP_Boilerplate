# Add A New API Feature

Use this checklist to add a new feature with the same flow used in this starter.

## 1) Define API contract

- Add DTO(s) in `data/remote/dto/<feature>/`.
- Add endpoint constants in `data/remote/api/NetworkConfig.kt` if needed.
- Add request defaults in `config/AppConfig.kt` if they are app-level defaults.

## 2) Create data source

- Extend or add API interface in `data/remote/api/`.
- Implement calls in `data/datasources/`.
- Keep Ktor request params and endpoint usage inside data source implementation.

## 3) Map to domain

- Add domain model(s) in `domain/model/`.
- Add mapper(s) in `data/mapper/`.
- Keep DTO usage out of UI layer.

## 4) Repository layer

- Add repository contract in `domain/repository/`.
- Add repository implementation in `data/repository/`.
- Use `BaseRepository.safeApiCall` for loading/success/error flow.

## 5) Use case

- Add use case in `domain/usecase/`.
- Keep method signature simple.
- Pull defaults from `config/AppConfig.kt` when needed.

## 6) ViewModel and UI state

- Add/update ViewModel in `presentation/ui/<feature>/`.
- Expose immutable `StateFlow` for UI.
- Map repository/use case result into `UiStatesResource`.

## 7) Screen

- Add/update composable screen in `presentation/ui/<feature>/`.
- Collect `StateFlow` with lifecycle-aware APIs.
- Render loading/success/error explicitly.

## 8) DI wiring

- Register data source/repository/use case/viewmodel in DI modules under `di/`.
- Keep module ownership clear (`NetworkModule`, `commonModule`, etc.).

## 9) Navigation

- Add route and destination in `presentation/ui/navigation/`.
- Add bottom/tab item only if the feature is top-level.

## 10) Quick validation

- Build Android: `bash gradlew :composeApp:compileDebugKotlinAndroid`
- Build iOS shared target: `bash gradlew :composeApp:compileKotlinIosSimulatorArm64`
