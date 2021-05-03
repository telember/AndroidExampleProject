plugins {
    id(PlugIns.androidApplication)
    kotlin(PlugIns.kotlinAndroid)
    kotlin(PlugIns.kotlinKapt)
    id(PlugIns.kotlinParcelize)
}

android {
    compileSdkVersion(Dependencies.Android.compileSdkVersion)
    buildToolsVersion = Dependencies.Android.buildToolsVersion

    defaultConfig {
        applicationId = Dependencies.Android.applicationId
        minSdkVersion(Dependencies.Android.minSdkVersion)
        targetSdkVersion(Dependencies.Android.targetSdkVersion)
        versionCode = Dependencies.Android.versionCode
        versionName = Dependencies.Android.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            resValue("string", "app_name", "Example Develop")
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-dev"
            isDebuggable = true
        }
        getByName("release") {
            resValue("string", "app_name", "Example")
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    bundle {
        language { enableSplit = true }
        density { enableSplit = true }
        abi { enableSplit = true }
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":common:core"))
    implementation(project(":common:share:data"))

    implementation(project(":feature:auth"))
    implementation(project(":feature:home"))

}