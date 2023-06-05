plugins {
    alias(deps.plugins.androidLibrary)
    alias(deps.plugins.kotlinPlugin)
    alias(deps.plugins.ksp)
//    alias(deps.plugins.hiltPlugin)
}

android {
    namespace = deps.versions.namespace.get() + ".network"
    compileSdk = deps.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = deps.versions.minSdk.get().toInt()
        targetSdk = deps.versions.targetSdk.get().toInt()

        testInstrumentationRunner = deps.versions.testInstrumentationRunner.get()
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

    testImplementation(deps.junit)
    androidTestImplementation(deps.androidJunit)

    testImplementation(deps.mockk)

    implementation(project(":corekotlin"))
}