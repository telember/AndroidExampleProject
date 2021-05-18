import Dependencies.addTesting

plugins {
    id("commons.android-library")
}

dependencies {
    implementation(project(":common:core"))
    implementation(project(":common:share:data"))

    addTesting()
}