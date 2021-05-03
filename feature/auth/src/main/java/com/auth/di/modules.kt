package com.auth.di

import com.auth.data.AuthService
import com.auth.data.AuthServiceImpl
import com.auth.domain.login.LoginUseCase
import com.auth.domain.login.LoginUseCaseImpl
import com.auth.navigatior.AuthRouter
import com.auth.presenter.AuthActivity
import com.auth.presenter.login.LoginViewController
import com.auth.presenter.login.LoginViewModel
import com.auth.presenter.login.view.LoginViewControllerImpl
import com.auth.presenter.register.RegisterViewModel
import core.navigation.Router
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authModule = module {
    single<Router> { AuthRouter() }
    single<AuthService> { AuthServiceImpl() }
    scope<AuthActivity> {
        scoped<LoginViewController> { LoginViewControllerImpl() }
        scoped<LoginUseCase> {
            LoginUseCaseImpl(appRepository = get(), service = get())
        }

        viewModel { RegisterViewModel(router = get()) }
        viewModel { LoginViewModel(router = get(), loginUseCase = get()) }
    }
}
