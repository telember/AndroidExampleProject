package com.home.navigator

import share.navigation.*

class HomeRouter(private val router: Router) : FeatureRoute(router) {

    override fun routeTo(destination: Destination) {
        super.routeTo(destination)
        when (destination) {
            is HomeToLogout -> router.routeToNavFlow(GlobalDestination.StartNav)
        }
    }
}
