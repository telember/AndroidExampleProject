package com.auth.presenter.register

import com.auth.navigator.RegisterToLogin
import core.view.BaseViewModel
import share.navigation.Router

class RegisterViewModel(
    private val router: Router,
) : BaseViewModel<RegisterEvent>() {

    fun performClickLogin() {
        router.routeTo(RegisterToLogin)
    }

    fun performRegister(email: String, password: String, confirmPassword: String) {
      //
    }
}
