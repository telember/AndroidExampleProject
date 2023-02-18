package share.navigation

class RouterImpl : Router() {

    override fun routeToNavFlow(destination: Destination) {
        super.routeToNavFlow(destination)
        when (destination) {
            GlobalDestination.StartNav -> navController?.navigate(R.id.action_global_start_flow)
            GlobalDestination.AuthNav -> navController?.navigate(R.id.action_global_auth_flow)
            GlobalDestination.HomeNav -> navController?.navigate(R.id.action_global_home_flow)
        }
    }

    override fun routeToPage(destination: DeepLinkDestination) {
        super.routeToPage(destination)
        navController?.deepLinkNavigateTo(destination)
    }
}
