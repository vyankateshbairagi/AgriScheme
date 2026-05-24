# AgriScheme

> Android app for agricultural scheme management and farmer assistance.

## Overview

AgriScheme is an Android application that helps manage agricultural schemes, collect field data, and provide resources to farmers. The project is an Android Gradle app located in the `app/` module.

## Prerequisites

- Java JDK 11 or newer
- Android Studio (recommended) or command-line Gradle
- Android SDK matching project configuration

## Setup

1. Ensure `google-services.json` is present in `app/` (configure Firebase if used).
2. Open the project in Android Studio, let it sync Gradle files.

Or build from the command line:

```bash
./gradlew clean assembleDebug
```

To install the debug APK on a connected device:

```bash
./gradlew installDebug
```

## Project structure

- `app/` — Android application module (source, resources, manifest)
- `gradle/` — Gradle wrapper
- Root Gradle files (`build.gradle`, `settings.gradle`, `gradle.properties`)

## Contributing

If you'd like to contribute, please open an issue or submit a pull request. Describe the changes and include steps to reproduce any bugs.

## License

Specify license here (e.g., MIT) or replace with your preferred license.

---

If you want, I can also add a minimal `README` section for developers (code style, testing, CI) or create a `CONTRIBUTING.md`.
