package share.navigation

import androidx.navigation.NavController

abstract class Router {

    var crossRouter: CrossRouter? = null
    var navController: NavController? = null
    var latestRoute: Destination? = null

    open fun routeTo(destination: Destination) {
        latestRoute = destination
    }
}
