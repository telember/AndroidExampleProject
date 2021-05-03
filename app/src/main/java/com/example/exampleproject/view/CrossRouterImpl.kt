package com.example.exampleproject.view

import android.app.Activity
import android.content.Intent
import com.auth.presenter.AuthActivity
import com.home.presenter.view.HomeActivity
import core.navigation.CrossRouter

class CrossRouterImpl : CrossRouter {
    override var activity: Activity? = null

    override fun routeToHomeActivity() {
        activity?.let {
            val intent = Intent(it, HomeActivity::class.java)
            it.startActivity(intent)
            it.finish()
        }
    }

    override fun routeToAuthActivity() {
        activity?.let {
            val intent = Intent(it, AuthActivity::class.java)
            it.startActivity(intent)
            it.finish()
        }
    }
}
