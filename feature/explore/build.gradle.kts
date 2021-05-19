import Dependencies.addTesting

plugins {
    id("commons.android-library")
    id("kotlin-android")
}

dependencies {
    implementation(project(":common:core"))
    implementation(project(":common:share:data"))

    addTesting()
}