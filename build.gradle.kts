// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    val kotlin_version by extra("1.5.0")
    repositories {
        google()
        jcenter()
        mavenCentral()
    }

    dependencies {
        classpath ("com.android.tools.build:gradle:4.2.1")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlinVersion}")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

subprojects {
    apply {
        from("$rootDir/gradle/ktlint.gradle.kts")
    }
}
