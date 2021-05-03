package com.auth.navigatior

import com.auth.R
import core.navigation.Destination
import core.navigation.Router

class AuthRouter : Router() {

    override fun routeTo(destination: Destination) {
        super.routeTo(destination)
        when (destination) {
            is LoginToRegister -> navController?.navigate(R.id.action_loginFragment_to_registerFragment)
            is RegisterToLogin -> navController?.navigate(R.id.action_registerFragment_to_loginFragment)
            is AuthToHome -> crossRouter?.routeToHomeActivity()
        }
    }
}
