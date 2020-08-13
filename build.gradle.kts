// cf. https://madhead.me/posts/kotlin-native-lambda/

import binaries.supplyEntryPoints
import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    kotlin("multiplatform") version "1.3.72"
    kotlin("plugin.serialization") version "1.3.70"
}

repositories {
    mavenLocal()
    jcenter()
    maven { setUrl("https://dl.bintray.com/kotlin/kotlinx.html/") }
}

kotlin {
    // TODO: define other block
    val ktorVersion = "1.3.2"

    sourceSets["commonMain"].apply {
        dependencies {
            implementation(kotlin("stdlib-common", KotlinCompilerVersion.VERSION))
            implementation("io.ktor:ktor-client-cio:$ktorVersion")
            implementation("io.ktor:ktor-client-json:$ktorVersion")
            implementation("io.ktor:ktor-client-json-native:$ktorVersion")
            implementation("io.ktor:ktor-client-serialization:$ktorVersion")
            implementation("io.ktor:ktor-client-serialization-native:$ktorVersion")
        }
    }

    sourceSets["commonTest"].apply {
        dependencies {
            implementation(kotlin("test-common", KotlinCompilerVersion.VERSION))
            implementation(kotlin("test-annotations-common", KotlinCompilerVersion.VERSION))
            implementation("io.ktor:ktor-client-mock:$ktorVersion")
            implementation("io.ktor:ktor-client-mock-native:$ktorVersion")
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
