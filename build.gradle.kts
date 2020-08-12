// cf. https://madhead.me/posts/kotlin-native-lambda/

import binaries.supplyEntryPoints

plugins {
    kotlin("multiplatform").version("1.3.72")
}

repositories {
    mavenLocal()
    jcenter()
    maven { setUrl("https://dl.bintray.com/kotlin/kotlinx.html/") }
}

kotlin {
    sourceSets["commonMain"].apply {
        dependencies {
            api("org.jetbrains.kotlin:kotlin-stdlib-common")
        }
    }

    sourceSets["commonTest"].apply {
        dependencies {
            api("org.jetbrains.kotlin:kotlin-test-common")
            api("org.jetbrains.kotlin:kotlin-test-annotations-common")
        }
    }

    val targets = listOf(
//      mingwX64(), // for windows
        macosX64(),
        linuxX64()
    )

    configure(targets) {
        compilations.all { kotlinOptions.verbose = true }

        binaries {
            supplyEntryPoints().forEach { entryPoint ->
                executable(entryPoint.packageName) {
                    this.entryPoint = entryPoint.entryPoint
                    runTask?.args(entryPoint.args)
                }
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
