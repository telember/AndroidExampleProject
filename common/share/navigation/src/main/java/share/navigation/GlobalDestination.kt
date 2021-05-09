package share.navigation

sealed class GlobalDestination {
    object StartNav : Destination
    object HomeNav : Destination
    object AuthNav : Destination
}
