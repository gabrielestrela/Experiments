import io.gitlab.arturbosch.detekt.Detekt

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(deps.plugins.foojayResolverConvertion) apply false
    alias(deps.plugins.agp) apply false
    alias(deps.plugins.androidLibrary) apply false
    alias(deps.plugins.kotlinPlugin) apply false
    alias(deps.plugins.ksp) apply false
    alias(deps.plugins.ktlint)
    alias(deps.plugins.detekt)
//    alias(deps.plugins.hiltPlugin) apply false
}

allprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    ktlint {
        debug.set(true)
        verbose.set(true)
        android.set(false)
        outputToConsole.set(true)
        outputColorName.set("RED")
        filter {
            enableExperimentalRules.set(true)
            exclude {
                projectDir.toURI().relativize(it.file.toURI()).path.contains("/generated")
            }
            include("**/kotlin/**")
        }
    }
}

detekt {
    buildUponDefaultConfig = true
    allRules = false
    autoCorrect = true
    parallel = true
    config = files("tools/detekt/config/detekt.yml")
}

tasks.withType<Detekt>().configureEach {
    reports {
        html.required.set(true) // observe findings in your browser with structure and code snippets
        txt.required.set(true) // similar to the console output, contains issue signature to manually edit baseline files
        md.required.set(true) // simple Markdown format
    }
}

tasks.withType<Detekt>().configureEach {
    jvmTarget = "17"
}
tasks.withType<io.gitlab.arturbosch.detekt.DetektCreateBaselineTask>().configureEach {
    jvmTarget = "17"
}

subprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")
    detekt {
        parallel = true
        config = files("${project.rootDir}/tools/detekt/config/detekt.yml")
    }
}

tasks.register("clean").configure {
    delete("build")
}
tasks.register("copyGitHooks", Copy::class.java) {
    description = "Copies the git hooks from /git-hooks to the .git folder."
    group = "git hooks"
    from("$rootDir/tools/scripts/pre-commit")
    into("$rootDir/.git/hooks/")
}
tasks.register("installGitHooks", Exec::class.java) {
    description = "Installs the pre-commit git hooks from /git-hooks."
    group = "git hooks"
    workingDir = rootDir
    commandLine = listOf("chmod")
    args("-R", "+x", ".git/hooks/")
    dependsOn("copyGitHooks")
    doLast {
        logger.info("Git hook installed successfully.")
    }
}

afterEvaluate {
    tasks.getByPath(":app:preBuild").dependsOn(":installGitHooks")
}
