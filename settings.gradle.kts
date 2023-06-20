pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }

    versionCatalogs {
        create("deps") {
            from(files("gradle/deps.toml"))
        }
    }
}

rootProject.name = "Experiments"
include(
    ":app",
    ":corekotlin",
    ":network",
    ":designsystem",
    ":navigation",
    ":features:home:implementation",
    ":features:home:public"
)
