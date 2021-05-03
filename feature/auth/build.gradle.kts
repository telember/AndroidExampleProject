import Dependencies.implementTesting

plugins {
    id("com.android.library")
    kotlin(PlugIns.kotlinAndroid)
}

android {
    compileSdkVersion(Dependencies.Android.compileSdkVersion)
    buildToolsVersion = Dependencies.Android.buildToolsVersion

    buildFeatures {
        viewBinding  = true
    }
}

dependencies {
    implementation(project(":common:core"))
    implementation(project(":common:share:data"))

    implementTesting()
}