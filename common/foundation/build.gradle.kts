import Dependencies.implementAndroidLifecycle
import Dependencies.implementGlide
import Dependencies.implementKoin
import Dependencies.implementKotlinCoroutine
import Dependencies.implementNavigation
import Dependencies.implementRetrofit
import Dependencies.implementSupportLibs

plugins {
    id("com.android.library")
}

android {
    compileSdkVersion(Dependencies.Android.compileSdkVersion)
    buildToolsVersion = Dependencies.Android.buildToolsVersion
}

dependencies {
    api(Dependencies.KotlinLibs.kotlinStd)
    implementKoin()
    implementKotlinCoroutine()
    implementNavigation()
    implementRetrofit()
    implementSupportLibs()
    implementGlide()
    implementAndroidLifecycle()
}