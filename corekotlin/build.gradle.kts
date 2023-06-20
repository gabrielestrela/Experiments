plugins {
    `java-library`
    kotlin("jvm")
}

//kotlin {
//    jvmToolchain(jdkVersion = 11)
//}

task("testUnitTest") {
    dependsOn("test")
}

dependencies {
    implementation(deps.koinCore)
//    implementation(deps.koinAndroid)

    testImplementation(deps.junit)

    testImplementation(deps.mockk)
}
