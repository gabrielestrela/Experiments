plugins {
    alias(deps.plugins.androidLibrary)
    alias(deps.plugins.kotlinPlugin)
    alias(deps.plugins.ksp)
//    alias(deps.plugins.hiltPlugin)
}

android {
    namespace = deps.versions.namespace.get() + ".network"
    compileSdk = deps.versions.compileSdk.get().toInt()

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        minSdk = deps.versions.minSdk.get().toInt()
        targetSdk = deps.versions.targetSdk.get().toInt()

        testInstrumentationRunner = deps.versions.testInstrumentationRunner.get()
//        buildConfigField("String", "WAPIS", System.getenv("WEATHER_API"))
        buildConfigField(
            type = "String",
            name = "WAPIS",
            value = "\"${providers.environmentVariable("WEATHER_API").get()}\""
        )
    }

    buildTypes {
        release {
            isMinifyEnabled = deps.versions.isMinifyEnabled.get().toBoolean()
            proguardFiles(
                getDefaultProguardFile(deps.versions.defaultProguardFile.get()),
                deps.versions.proguardFile.get()
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = deps.versions.jvmTarget.get()
    }

    packagingOptions {
        resources.excludes.apply {
            add("META-INF/licenses/**")
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
        }
    }
}

dependencies {
    implementation(deps.coreKtx)

    implementation(deps.koinCore)
//    implementation(deps.koinAndroid)

    implementation(deps.retrofit)
    implementation(deps.retrofitMoshiConverter)
    implementation(deps.moshiKotlin)

    debugImplementation(deps.flipper)
    debugImplementation(deps.flipperNetworkPlugin)
    releaseImplementation(deps.flipperNoop)

    testImplementation(deps.junit)
    androidTestImplementation(deps.androidJunit)

    testImplementation(deps.mockk)

    implementation(project(":corekotlin"))
}
