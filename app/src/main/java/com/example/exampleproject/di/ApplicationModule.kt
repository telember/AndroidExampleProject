package com.example.exampleproject.di

import com.auth.di.authModule
import com.home.di.homeModules
import share.data.di.shareDataModule

val appModules = authModule +
    homeModules +
    shareDataModule +
    singleModules
