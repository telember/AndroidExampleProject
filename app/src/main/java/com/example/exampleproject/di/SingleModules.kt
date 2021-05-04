package com.example.exampleproject.di

import share.navigation.CrossRouterImpl
import org.koin.dsl.module
import share.data.data.repository.AppRepository
import share.data.data.repository.AppRepositoryImpl
import share.navigation.CrossRouter

val singleModules = module {
    single<AppRepository> { AppRepositoryImpl() }
    single<CrossRouter> { CrossRouterImpl() }
}
