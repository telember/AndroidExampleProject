package com.auth.presenter.register

import com.auth.navigator.RegisterToLogin
import core.view.BaseViewModel
import kotlinx.coroutines.CoroutineDispatcher
import share.navigation.FeatureRoute

class RegisterViewModel(
    private val router: FeatureRoute
) : BaseViewModel<RegisterEvent>() {

    fun performClickLogin() {
        router.routeTo(RegisterToLogin)
    }

    fun performRegister(email: String, password: String, confirmPassword: String) {
      //
    }
}
