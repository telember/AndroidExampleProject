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
    const val navVersion = "2.3.5"
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
        api("org.koin:koin-androidx-scope:${Version.koinVersion}")
        api("org.koin:koin-androidx-viewmodel:${Version.koinVersion}")
        api("org.koin:koin-androidx-fragment:${Version.koinVersion}")
        api("org.koin:koin-androidx-compose:${Version.koinVersion}")
        api("org.koin:koin-androidx-ext:${Version.koinVersion}")
    }

    fun DependencyHandlerScope.implementGlide() {
        api("com.github.bumptech.glide:glide:4.12.0")
        api("com.github.bumptech.glide:annotations:4.12.0")
        add("annotationProcessor", "com.github.bumptech.glide:compiler:4.12.0")
        api("jp.wasabeef:glide-transformations:4.3.0")
    }

    fun DependencyHandlerScope.implementAndroidLifecycle() {
        api("androidx.lifecycle:lifecycle-common-java8:${Version.lifecycleVersion}")
        api("androidx.lifecycle:lifecycle-extensions:${Version.lifecycleVersion}")
        api("androidx.lifecycle:lifecycle-reactivestreams-ktx:${Version.lifecycleVersion}")
        api("androidx.lifecycle:lifecycle-runtime:${Version.lifecycleVersion}")
    }

    fun DependencyHandlerScope.implementSupportLibs() {
        api("androidx.multidex:multidex:2.0.1")

        api("com.google.android.material:material:1.3.0")
        api("androidx.core:core-ktx:${Version.androidKTXVersion}")
        api("androidx.appcompat:appcompat:${Version.appcompatVersion}")

        api("androidx.cardview:cardview:1.0.0")
        api("androidx.recyclerview:recyclerview:1.2.0-alpha04")
        api("androidx.viewpager2:viewpager2:1.0.0")
        api("androidx.core:core-ktx:1.5.0-alpha02")
        api("androidx.constraintlayout:constraintlayout:${Version.constraintLayoutVersion}")
    }

    fun DependencyHandlerScope.implementKotlinCoroutine() {
        api("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutinesVersion}")
        api("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutinesVersion}")
    }

    fun DependencyHandlerScope.implementNavigation() {
        api("androidx.navigation:navigation-runtime:${Version.navVersion}")
        api("androidx.navigation:navigation-fragment-ktx:${Version.navVersion}")
        api("androidx.navigation:navigation-ui-ktx:${Version.navVersion}")
    }

    fun DependencyHandlerScope.implementRetrofit() {
        api("com.squareup.retrofit2:retrofit:${Version.retrofitVersion}")
        api("com.squareup.retrofit2:converter-gson:${Version.retrofitVersion}")
        api("com.squareup.retrofit2:converter-scalars:2.1.0")
        api("com.squareup.okhttp3:okhttp:${Version.okHttpVersion}")
        api("com.squareup.okhttp3:logging-interceptor:${Version.okHttpVersion}")
        api(

            "com.squareup.okhttp3:okhttp-urlconnection:${Version.okHttpVersion}"
        )
    }

    fun DependencyHandlerScope.implementTesting() {
        testImplementation("org.junit.jupiter:junit-jupiter-api:${Version.junitVersion}")
        testImplementation("org.junit.jupiter:junit-jupiter-engine:${Version.junitVersion}")
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutinesVersion}")

        testImplementation("androidx.test:core:1.3.0")
        testImplementation("androidx.arch.core:core-testing:2.1.0")
        // Mocking
        testImplementation("org.mockito:mockito-core:${Version.mockitoVersion}")
        testImplementation("org.mockito:mockito-inline:${Version.mockitoVersion}")
        // Kotlin
        testImplementation("org.jetbrains.kotlin:kotlin-test:${Version.kotlinVersion}")
        testImplementation("org.jetbrains.kotlin:kotlin-reflect:${Version.kotlinVersion}")
        // Koin
        testImplementation("org.koin:koin-test:${Version.koinVersion}")
        // Spek
        testImplementation("org.spekframework.spek2:spek-dsl-jvm:${Version.spekVersion}")
        testImplementation(

            "org.spekframework.spek2:spek-runner-junit5:${Version.spekVersion}"
        )

        testImplementation("androidx.test:runner:${Version.runnerVersion}")
        testImplementation("androidx.test.ext:junit:${Version.junitExtVersion}")

        add(
            "androidTestImplementation",
            "androidx.test.espresso:espresso-core:${Version.espressoVersion}"
        )
        add("androidTestImplementation", "androidx.test:runner:${Version.runnerVersion}")

    }

    private fun DependencyHandlerScope.api(notation: Any) {
        add("api", notation)
    }

    private fun DependencyHandlerScope.testImplementation(notation: Any) {
        add("testImplementation", notation)
    }
}


