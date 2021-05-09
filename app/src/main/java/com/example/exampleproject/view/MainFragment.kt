package com.example.exampleproject.view

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.exampleproject.R
import core.view.BaseFragment
import org.koin.android.ext.android.inject
import share.navigation.GlobalDestination
import share.navigation.Router

class MainFragment : BaseFragment(R.layout.fragment_main) {

    private val router: Router by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialRoute()
    }

    private fun initialRoute() {
        router.navController = findNavController()
        router.routeToNavFlow(GlobalDestination.AuthNav)
    }
}