package com.home.di

import com.home.navigator.HomeRouter
import com.home.presenter.view.HomeActivity
import com.home.presenter.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import share.navigation.Router

val homeModules = module {
    scope<HomeActivity> {
        scoped<Router> { HomeRouter() }
        viewModel {
            HomeViewModel(
                router = get(),
                getUserUseCase = get())
        }
    }
}
