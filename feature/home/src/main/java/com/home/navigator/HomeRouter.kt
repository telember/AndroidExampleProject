package com.home.navigator

import share.navigation.Destination
import share.navigation.FeatureRoute
import share.navigation.GlobalDestination
import share.navigation.Router

class HomeRouter(private val router: Router) : FeatureRoute(router) {

    override fun routeTo(destination: Destination) {
        super.routeTo(destination)
        when (destination) {
            is HomeToLogout -> router.routeToNavFlow(GlobalDestination.StartNav)
        }
    }
}
