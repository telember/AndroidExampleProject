plugins {
    id("com.android.library")
    kotlin(PlugIns.kotlinAndroid)
}

android {
    compileSdkVersion(Dependencies.Android.compileSdkVersion)
    buildToolsVersion = Dependencies.Android.buildToolsVersion

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    api(project(":common:foundation"))
}