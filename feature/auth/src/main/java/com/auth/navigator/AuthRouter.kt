package com.auth.navigator

import com.auth.R
import share.navigation.DeepLinkDestination
import share.navigation.Destination
import share.navigation.FeatureRoute
import share.navigation.Router

class AuthRouter(private val route: Router) : FeatureRoute(route) {

    override fun routeTo(destination: Destination) {
        super.routeTo(destination)
        when (destination) {
            is LoginToRegister -> route.navController?.navigate(R.id.action_loginFragment_to_registerFragment)
            is RegisterToLogin -> route.navController?.navigate(R.id.action_registerFragment_to_loginFragment)
            is AuthToHome -> route.crossRoute(DeepLinkDestination.Home)
        }
    }
}
