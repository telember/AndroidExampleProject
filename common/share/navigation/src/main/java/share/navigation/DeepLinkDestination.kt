package share.navigation

sealed class DeepLinkDestination(val address: String) {
    object Home : DeepLinkDestination("example://home")
    object Login : DeepLinkDestination("example://login")
    object Register : DeepLinkDestination("example://register")
}