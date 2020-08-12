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
- [ ] arrange source directory structure
- [ ] import JSON serializer
- [ ] import ktor
  - [ ] use HTTP Client
- [ ] import DI library
  - kodein?
- [ ] on IntelliJ IDEA
  - [ ] run
  - [ ] debug
  - [x] unit test
  - [ ] sam local (AWS Serverless Application Model)
- [ ] deploy
- [ ] create API test
  - [ ] [preacher][preacher]

[example to build at once]: https://github.com/JetBrains/kotlin/blob/1.3.20/libraries/tools/kotlin-gradle-plugin-integration-tests/src/test/resources/testProject/new-mpp-native-binaries/kotlin-dsl/build.gradle.kts
[preacher]: https://github.com/ymoch/preacher

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
```console
$ ./build/bin/linuxX64/sampleReleaseExecutable/sample.kexe
Hello, Kotlin/Native!
```

### Test
#### on Mac
```console
$ ./gradlew allTests

> Configure project :
Kotlin Multiplatform Projects are an experimental feature.

BUILD SUCCESSFUL in 1s
8 actionable tasks: 2 executed, 6 up-to-date
```


## Setup
### to run `sam local` on IntelliJ IDEA
### on mac
1. Install [Homebrew][Homebrew]
2. Install AWS CLI2
  * `brew install awscli`



[Homebrew]: https://brew.sh/
[Installing the AWS Toolkit for JetBrains]: https://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/setup-toolkit.html
