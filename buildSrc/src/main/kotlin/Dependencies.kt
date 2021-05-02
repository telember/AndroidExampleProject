import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope

internal object Version {

    const val androidKTXVersion = "1.1.0"
    const val appcompatVersion = "1.1.0"
    const val constraintLayoutVersion = "1.1.3"
    const val coroutinesVersion = "1.4.2"
    const val googleServiceVersion = "4.3.3"
    const val koinVersion = "2.2.2"
    const val kotlinVersion = "1.4.32"
    const val lifecycleVersion = "2.1.0"
    const val mockitoVersion = "3.8.0"
    const val okHttpVersion = "4.9.1"
    const val retrofitVersion = "2.9.0"
    const val spekVersion = "2.0.15"

    //test libs
    const val junitVersion = "5.7.1"
    const val junitExtVersion = "1.1.1"
    const val runnerVersion = "1.1.0"
    const val espressoVersion = "3.1.0"
}

object PlugIns {
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "android"
    const val kotlinParcelize = "kotlin-parcelize"
    const val kotlinKapt = "kapt"
}

object Dependencies {

    object Android {
        const val minSdkVersion = 21
        const val targetSdkVersion = 30
        const val compileSdkVersion = 30
        const val buildToolsVersion = "30.0.2"
        const val applicationId = "com.example.exampleproject"
        const val versionCode = 1
        const val versionName = "0.1"
    }

    object KotlinLibs {
        const val kotlinStd = "org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlinVersion}"
    }

    object GoogleService {
        const val googleService = "com.google.gms:google-services:${Version.googleServiceVersion}"
    }

    fun DependencyHandlerScope.implementKoin() {
        add("api", "org.koin:koin-androidx-scope:${Version.koinVersion}")
        add("api", "org.koin:koin-androidx-viewmodel:${Version.koinVersion}")
        add("api", "org.koin:koin-androidx-fragment:${Version.koinVersion}")
        add("api", "org.koin:koin-androidx-compose:${Version.koinVersion}")
        add("api", "org.koin:koin-androidx-ext:${Version.koinVersion}")
    }

    fun DependencyHandlerScope.implementGlide() {
        add("api", "com.github.bumptech.glide:glide:4.12.0")
        add("api", "com.github.bumptech.glide:annotations:4.12.0")
        add("annotationProcessor", "com.github.bumptech.glide:compiler:4.12.0")
        add("api", "jp.wasabeef:glide-transformations:4.3.0")
    }

    fun DependencyHandlerScope.implementAndroidLifecycle() {
        add("api", "androidx.lifecycle:lifecycle-common-java8:${Version.lifecycleVersion}")
        add("api", "androidx.lifecycle:lifecycle-extensions:${Version.lifecycleVersion}")
        add("api", "androidx.lifecycle:lifecycle-reactivestreams-ktx:${Version.lifecycleVersion}")
        add("api", "androidx.lifecycle:lifecycle-runtime:${Version.lifecycleVersion}")
    }

    fun DependencyHandlerScope.implementSupportLibs() {
        add("api", "androidx.multidex:multidex:2.0.1")

        add("api", "com.google.android.material:material:1.2.0")
        add("api", "androidx.core:core-ktx:${Version.androidKTXVersion}")
        add("api", "androidx.appcompat:appcompat:${Version.appcompatVersion}")

        add("api", "androidx.cardview:cardview:1.0.0")
        add("api", "androidx.recyclerview:recyclerview:1.2.0-alpha04")
        add("api", "androidx.viewpager2:viewpager2:1.0.0")
        add("api", "androidx.core:core-ktx:1.5.0-alpha02")
        add("api", "androidx.constraintlayout:constraintlayout:${Version.constraintLayoutVersion}")
    }

    fun DependencyHandlerScope.implementKotlinCoroutine() {
        add("api", "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutinesVersion}")
        add("api", "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutinesVersion}")
    }

    fun DependencyHandlerScope.implementNavigation() {
        add("api", "androidx.navigation:navigation-fragment-ktx:2.3.0")
        add("api", "androidx.navigation:navigation-ui-ktx:2.3.0")
    }

    fun DependencyHandlerScope.implementRetrofit() {
        add("api", "com.squareup.retrofit2:retrofit:${Version.retrofitVersion}")
        add("api", "com.squareup.retrofit2:converter-gson:${Version.retrofitVersion}")
        add("api", "com.squareup.retrofit2:converter-scalars:2.1.0")
        add("api", "com.squareup.okhttp3:okhttp:${Version.okHttpVersion}")
        add("api", "com.squareup.okhttp3:logging-interceptor:${Version.okHttpVersion}")
        add(
            "testImplementation",
            "com.squareup.okhttp3:okhttp-urlconnection:${Version.okHttpVersion}"
        )
    }

    fun DependencyHandlerScope.implementTesting() {
        add("testImplementation", "org.junit.jupiter:junit-jupiter-api:${Version.junitVersion}")
        add("testImplementation", "org.junit.jupiter:junit-jupiter-engine:${Version.junitVersion}")
        add(
            "testImplementation",
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutinesVersion}"
        )

        add("testImplementation", "androidx.test:core:1.3.0")
        add("testImplementation", "androidx.arch.core:core-testing:2.1.0")
        // Mocking
        add("testImplementation", "org.mockito:mockito-core:${Version.mockitoVersion}")
        add("testImplementation", "org.mockito:mockito-inline:${Version.mockitoVersion}")
        // Kotlin
        add("testImplementation", "org.jetbrains.kotlin:kotlin-test:${Version.kotlinVersion}")
        add("testImplementation", "org.jetbrains.kotlin:kotlin-reflect:${Version.kotlinVersion}")
        // Koin
        add("testImplementation", "org.koin:koin-test:${Version.koinVersion}")
        // Spek
        add("testImplementation", "org.spekframework.spek2:spek-dsl-jvm:${Version.spekVersion}")
        add("testImplementation", "org.spekframework.spek2:spek-runner-junit5:${Version.spekVersion}")

        add("testImplementation", "androidx.test:runner:${Version.runnerVersion}")
        add("testImplementation", "androidx.test.ext:junit:${Version.junitExtVersion}")
        add(
            "androidTestImplementation",
            "androidx.test.espresso:espresso-core:${Version.espressoVersion}"
        )
        add("androidTestImplementation", "androidx.test:runner:${Version.runnerVersion}")

    }
}


