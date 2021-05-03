package com.auth.presenter.login

import com.auth.domain.login.LoginUseCase
import com.auth.domain.login.model.LoginModel
import com.auth.navigator.AuthToHome
import com.auth.navigator.LoginToRegister
import core.navigation.Router
import core.view.BaseViewModel

class LoginViewModel(
    private val router: Router,
    private val loginUseCase: LoginUseCase
) : BaseViewModel<LoginEvent>() {

    fun performClickRegisterButton() {
        router.routeTo(LoginToRegister)
    }

    fun performLogin(email: String, password: String) {
        onBackground {
            postEvent(LoginEvent.Loading)
            //TODO call login useCase
            val user = loginUseCase.execute(LoginModel(email, password))
            if (user != null) {
                postEvent(LoginEvent.LoginSuccess(user.name))
                router.routeTo(AuthToHome)
            } else {
                postEvent(LoginEvent.LoginError)
            }
        }
    }
}
