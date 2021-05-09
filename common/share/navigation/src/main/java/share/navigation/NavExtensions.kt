package share.navigation

import androidx.annotation.MainThread
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavOptions

fun buildDeepLink(destination: DeepLinkDestination) =
    NavDeepLinkRequest.Builder
        .fromUri(destination.address.toUri())
        .build()

@MainThread
fun NavController.deepLinkNavigateTo(
    deepLinkDestination: DeepLinkDestination
) {
    navigate(buildDeepLink(deepLinkDestination))
}


