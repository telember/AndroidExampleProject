package com.auth.presenter.login

import com.auth.domain.login.LoginUseCase
import com.auth.domain.login.model.LoginModel
import com.auth.navigator.AuthToHome
import com.auth.navigator.LoginToRegister
import core.view.BaseViewModel
import share.navigation.FeatureRoute

class LoginViewModel(
    private val router: FeatureRoute,
    private val loginUseCase: LoginUseCase,
) : BaseViewModel<LoginEvent>() {

    fun performClickRegisterButton() {
        router.routeTo(LoginToRegister)
    }

    fun performLogin(email: String, password: String) {
        launchDataLoad({
            postEvent(LoginEvent.Loading)
            val user = loginUseCase.execute(LoginModel(email, password))
            if (user != null) {
                LoginEvent.LoginSuccess(user.name)
                router.routeTo(AuthToHome)
            } else {
                LoginEvent.LoginError
            }
        }, {
        })
    }
}
