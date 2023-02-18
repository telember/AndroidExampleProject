package com.auth.navigator

import com.auth.R
import share.navigation.Destination
import share.navigation.FeatureRoute
import share.navigation.GlobalDestination
import share.navigation.Router

class AuthRouter(private val router: Router) : FeatureRoute(router) {

    override fun routeTo(destination: Destination) {
        super.routeTo(destination)
        when (destination) {
            is LoginToRegister -> router.currentBottomNavController?.navigate(R.id.action_loginFragment_to_registerFragment)
            is RegisterToLogin -> router.currentBottomNavController?.navigate(R.id.action_registerFragment_to_loginFragment)
            is AuthToHome -> router.routeToNavFlow(GlobalDestination.HomeNav)
        }
    }
}
