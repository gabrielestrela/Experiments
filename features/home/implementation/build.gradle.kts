plugins {
    alias(deps.plugins.androidLibrary)
    alias(deps.plugins.kotlinPlugin)
    alias(deps.plugins.ksp)
//    alias(deps.plugins.hiltPlugin)
}

android {
    namespace = deps.versions.namespace.get() + ".home.impl"
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

    buildFeatures {
        compose = deps.versions.useCompose.get().toBoolean()
    }

    composeOptions {
        kotlinCompilerExtensionVersion = deps.versions.composeKotlinCompilerExtensionVersion.get()
    }

    packagingOptions {
        resources.excludes.apply {
            add("META-INF/licenses/**")
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
        }
    }
}

kotlin {
    jvmToolchain(jdkVersion = 11)
}

dependencies {
    implementation(deps.coreKtx)
    implementation(deps.appCompat)
    implementation(deps.material)
    implementation(deps.constraintLayout)

    implementation(deps.koinCore)
    implementation(deps.koinAndroid)

    implementation(deps.composeRuntime)

    val composeBom = platform(deps.composeBom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation(deps.composeFoundation)
    implementation(deps.composeUi)
    implementation(deps.material3)
    implementation(deps.composeToolingPreview)
    implementation(deps.composeNavigation)
    debugImplementation(deps.composeUiTooling)

    implementation(deps.retrofit)

    implementation(deps.moshi)
    ksp(deps.moshiCodeGen)

    androidTestImplementation(deps.composeUiJunit4)
    debugImplementation(deps.composeUiTestManifest)

    testImplementation(deps.junit)
    androidTestImplementation(deps.androidJunit)

    testImplementation(deps.mockk)

    implementation(project(":designsystem"))
    implementation(project(":navigation"))
    implementation(project(":corekotlin"))
    implementation(project(":network"))
}
