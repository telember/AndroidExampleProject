package com.home.navigator

import core.navigation.Destination
import core.navigation.Router

class HomeRouter : Router() {
    override fun routeTo(destination: Destination) {
        super.routeTo(destination)
        when (destination) {
            is HomeToAuth -> crossRouter?.routeToAuthActivity()
        }
    }
}
