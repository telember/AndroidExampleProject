package com.home.navigator

import share.navigation.DeepLinkDestination
import share.navigation.Destination
import share.navigation.FeatureRoute
import share.navigation.Router

class HomeRouter(private val route: Router) : FeatureRoute(route) {

    override fun routeTo(destination: Destination) {
        super.routeTo(destination)
        when (destination) {
            is HomeToAuth -> route.crossRoute(DeepLinkDestination.Login)
        }
    }
}
