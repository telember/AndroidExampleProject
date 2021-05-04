package com.home.navigator

import share.navigation.Destination
import share.navigation.Router

class HomeRouter : Router() {
    override fun routeTo(destination: Destination) {
        super.routeTo(destination)
        when (destination) {
            is HomeToAuth -> crossRouter?.routeToAuthActivity()
        }
    }
}
