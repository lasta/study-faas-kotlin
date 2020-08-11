// cf. https://madhead.me/posts/kotlin-native-lambda/
plugins {
    kotlin("multiplatform").version("1.3.72")
}

repositories {
    jcenter()
}

kotlin {
    // For ARM, should be changed to iosArm32 or iosArm64
    // For Linux, should be changed to e.g. linuxX64
    // For MacOS, should be changed to e.g. macosX64
    // For Windows, should be changed to e.g. mingwX64
    // https://github.com/JetBrains/kotlin/blob/1.3.20/libraries/tools/kotlin-gradle-plugin-integration-tests/src/test/resources/testProject/new-mpp-native-binaries/kotlin-dsl/build.gradle.kts
    macosX64("macos") {
        binaries {
            executable("sample") {
                // Change to specify fully qualified name of your application's entry point:
               entryPoint = "sample.main"
                // Specify command-line arguments, if necessary:
//                runTask?.args("")
            }
            executable("sample2") {
                // Change to specify fully qualified name of your application's entry point:
                entryPoint = "sample2.main"
            }
        }
    }
}

tasks {
    wrapper {
        gradleVersion = "6.6"
        distributionType = Wrapper.DistributionType.ALL
    }
}

