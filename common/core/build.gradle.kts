plugins {
    id("commons.android-library")
}

dependencies {
    api(project(":common:foundation"))
    api(project(":common:share:navigation"))
    api(project(":common:share:resources"))
}