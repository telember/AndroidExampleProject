package share.navigation

import androidx.navigation.NavController

abstract class Router {

    var navController: NavController? = null
    var latestRoute: Destination? = null

    fun currentDestination(destination: Destination) {
        latestRoute = destination
    }

    fun crossRoute(deepLink: DeepLinkDestination){
        navController?.deepLinkNavigateTo(deepLink)
    }
}
