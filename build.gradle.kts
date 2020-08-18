// cf. https://madhead.me/posts/kotlin-native-lambda/

import binaries.supplyEntryPoints
import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    kotlin("multiplatform") version "1.4.0"
    kotlin("plugin.serialization") version "1.4.0"
}

repositories {
    jcenter()
}

kotlin {
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    nativeTarget.apply {
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

    sourceSets {
        val ktorVersion = "1.3.2-1.4.0-rc"
        val serializationVersion = "1.0.0-RC"
        val nativeMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-curl:$ktorVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$serializationVersion")
            }
        }
        val nativeTest by getting {
            dependencies {
                implementation(kotlin("test-common", KotlinCompilerVersion.VERSION))
                implementation(kotlin("test-annotations-common", KotlinCompilerVersion.VERSION))
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
