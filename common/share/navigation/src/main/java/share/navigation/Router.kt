package share.navigation

import androidx.navigation.NavController

abstract class Router {

    var navController: NavController? = null
    var currentBottomNavController: NavController? = null
    var latestRoute: Destination? = null

    open fun routeToNavFlow(destination: Destination) {
        latestRoute = destination
    }

    open fun routeToPage(destination: DeepLinkDestination) {}
}
