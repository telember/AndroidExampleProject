plugins {
    id("com.android.library")
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