package core.navigation

import android.app.Activity

interface CrossRouter {
    var activity: Activity?
    fun routeToHomeActivity()
    fun routeToAuthActivity()
}
