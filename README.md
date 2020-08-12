# Study FaaS with Kotlin-Native

## TODO
- [x] migrate from `build.gradle` to `build.gradle.kts`
- [x] run "Hello, World!"
  - [x] on mac
  - [x] on Amazon Linux 2
- [x] cross-compile for platforms at once
  - [sample][example to build at once]
- [x] mark project structure automatically by IntelliJ IDEA
- [ ] clean up `build.gradle.kts`
  - [ ] create `buildSrc`
- [ ] arrange directory structure
- [ ] import JSON serializer
- [ ] import ktor
  - [ ] use HTTP Client
- [ ] import DI library
  - kodein?
- [ ] run and debug codes on IntelliJ IDEA
- [ ] run and debug on Alpine Linux on Docker for Mac

[example to build at once]: https://github.com/JetBrains/kotlin/blob/1.3.20/libraries/tools/kotlin-gradle-plugin-integration-tests/src/test/resources/testProject/new-mpp-native-binaries/kotlin-dsl/build.gradle.kts

## TL;DR
### build
```sh
./gradlew build
```

Initially, it may take several minutes.

### Run
#### on Mac
```console
$ ./build/bin/macosX64/sampleReleaseExecutable/sample.kexe
Hello, Kotlin/Native!
```

### on Linux
```
$ ./build/bin/linuxX64/sampleReleaseExecutable/sample.kexe
Hello, Kotlin/Native!
```

