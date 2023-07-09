plugins {
    alias(deps.plugins.agp)
    alias(deps.plugins.kotlinPlugin)
    alias(deps.plugins.ksp)
//    alias(deps.plugins.hiltPlugin)
}

android {
    namespace = deps.versions.namespace.get()
    compileSdk = deps.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = deps.versions.applicationId.get()
        minSdk = deps.versions.minSdk.get().toInt()
        targetSdk = deps.versions.targetSdk.get().toInt()
        versionCode = deps.versions.versionCode.get().toInt()
        versionName = deps.versions.versionName.get()

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
        debug {
            isMinifyEnabled = false
            isDebuggable = true
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
        viewBinding = deps.versions.useViewBinding.get().toBoolean()
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
    implementation(deps.material3)
    implementation(deps.constraintLayout)

    implementation(deps.moshi)
    ksp(deps.moshiCodeGen)

    implementation(deps.koinCore)
//    implementation(deps.koinAndroid)
    implementation(deps.koinCompose)
    implementation(deps.koinComposeNavigation)

    implementation(deps.composeRuntime)

    val composeBom = platform(deps.composeBom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation(deps.composeFoundation)
    implementation(deps.composeUi)
    implementation(deps.composeToolingPreview)
    debugImplementation(deps.composeUiTooling)
    implementation(deps.composeNavigation)

    androidTestImplementation(deps.composeUiJunit4)
    debugImplementation(deps.composeUiTestManifest)

    debugImplementation(deps.flipper)
    debugImplementation(deps.soLoader)
    debugImplementation(deps.flipperNetworkPlugin)
    releaseImplementation(deps.flipperNoop)

    testImplementation(deps.junit)
    androidTestImplementation(deps.androidJunit)
    androidTestImplementation(deps.espressoCore)

    testImplementation(deps.mockk)

    implementation(project(":network"))
    implementation(project(":designsystem"))
    implementation(project(":corekotlin"))
    implementation(project(":coreandroid"))
    implementation(project(":navigation"))
    implementation(project(":features:home:implementation"))
}
