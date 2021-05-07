package share.navigation

abstract class FeatureRoute(private val router: Router) {

    open fun routeTo(destination: Destination) {
        router.currentDestination(destination)
    }
}
