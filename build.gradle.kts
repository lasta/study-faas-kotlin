// cf. https://madhead.me/posts/kotlin-native-lambda/
plugins {
    kotlin("multiplatform").version("1.3.72")
}

repositories {
    jcenter()
    maven { setUrl("https://dl.bintray.com/kotlin/kotlinx.html/") }
}

kotlin {
    sourceSets["commonMain"].apply {
        dependencies {
            api("org.jetbrains.kotlin:kotlin-stdlib-common")
        }
    }

    val targets = listOf(
//      mingwX64("mingw"), // for windows
        macosX64("macos"),
        linuxX64("linux")
    )

    configure(targets) {
        binaries {
            executable("sample") {
                entryPoint = "sample.main"
                // Specify command-line arguments, if necessary:
                // runTask?.args("")
            }
            executable("sample2") {
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

