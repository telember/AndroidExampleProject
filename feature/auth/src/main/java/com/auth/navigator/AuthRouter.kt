package com.auth.navigator

import com.auth.R
import share.navigation.*

class AuthRouter(private val router: Router) : FeatureRoute(router) {

    override fun routeTo(destination: Destination) {
        super.routeTo(destination)
        when (destination) {
            is LoginToRegister -> router.navController?.navigate(R.id.action_loginFragment_to_registerFragment)
            is RegisterToLogin -> router.navController?.navigate(R.id.action_registerFragment_to_loginFragment)
            is AuthToHome -> router.routeToNavFlow(GlobalDestination.HomeNav)
        }
    }
}
