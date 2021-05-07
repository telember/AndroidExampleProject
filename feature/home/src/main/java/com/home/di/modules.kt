package com.home.di

import com.home.navigator.HomeRouter
import com.home.presenter.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import share.navigation.FeatureRoute

private const val HOME_ROUTER = "home_router"

val homeModules = module {
    single<FeatureRoute>(named(HOME_ROUTER)) { HomeRouter(get()) }
    viewModel {
        HomeViewModel(
            router = get(named(HOME_ROUTER)),
            getUserUseCase = get())
    }
}
