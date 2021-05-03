package com.auth.presenter.register

import com.auth.navigatior.RegisterToLogin
import core.navigation.Router
import core.view.BaseViewModel

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
