package com.example.exampleproject.di

import com.example.exampleproject.view.CrossRouterImpl
import core.navigation.CrossRouter
import org.koin.dsl.module
import share.data.data.repository.AppRepository
import share.data.data.repository.AppRepositoryImpl

val singleModules = module {
    single<AppRepository> { AppRepositoryImpl() }
    single<CrossRouter> { CrossRouterImpl() }
}
