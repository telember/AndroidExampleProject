package com.example.exampleproject.di

import org.koin.dsl.module
import share.data.data.repository.AppRepository
import share.data.data.repository.AppRepositoryImpl
import share.navigation.Router
import share.navigation.RouterImpl

val singleModules = module {
    single<AppRepository> { AppRepositoryImpl() }
    single<Router> { RouterImpl() }
}
