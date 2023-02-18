package com.auth.di

import com.auth.data.AuthService
import com.auth.data.AuthServiceImpl
import com.auth.domain.login.LoginUseCase
import com.auth.domain.login.LoginUseCaseImpl
import com.auth.navigator.AuthRouter
import com.auth.presenter.login.LoginViewController
import com.auth.presenter.login.LoginViewModel
import com.auth.presenter.login.view.LoginViewControllerImpl
import com.auth.presenter.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import share.navigation.FeatureRoute

private const val AUTH_ROUTER = "auth_router"

val authModule = module {

    single<FeatureRoute>(named(AUTH_ROUTER)) { AuthRouter(get()) }
    single<AuthService> { AuthServiceImpl() }
    factory<LoginViewController> { LoginViewControllerImpl() }
    factory<LoginUseCase> {
        LoginUseCaseImpl(appRepository = get(), service = get())
    }
    viewModel {
        LoginViewModel(
            router = get(named(AUTH_ROUTER)),
            loginUseCase = get(),
        )
    }
    viewModel { RegisterViewModel(router = get(named(AUTH_ROUTER))) }
}
