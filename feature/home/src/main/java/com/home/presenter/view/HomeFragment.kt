package com.home.presenter.view

import android.os.Bundle
import android.view.View
import com.home.R
import com.home.databinding.FragmentHomeBinding
import com.home.presenter.HomeEvent
import com.home.presenter.HomeViewModel
import core.view.BaseFragment
import core.view.setupWithNavController
import core.view.viewBinding
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel
import share.navigation.Router

class HomeFragment : BaseFragment(R.layout.fragment_home) {
    private val router: Router = get()
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        viewModel.onStart()
        setupBottomNavigationBar()
    }

    private fun initListener() {

        viewModel.event.observe(this, ::handleEvent)
    }

    private fun handleEvent(event: HomeEvent?) {
        when (event) {
            is HomeEvent.Greeting -> setToolbar(event)
            else -> {
            }
        }
    }

    private fun setToolbar(greeting: HomeEvent.Greeting) {

    }

    private fun setupBottomNavigationBar() {

        val navGraphIds = listOf(
            R.navigation.nav_explore,
            R.navigation.nav_auth
        )

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = binding.bottomNav.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = childFragmentManager,
            containerId = R.id.nav_host_container
        )
        controller.observe(viewLifecycleOwner, { navController ->
            router.currentBottomNavController = navController
            router.currentBottomNavController?.addOnDestinationChangedListener { controller, destination, arguments ->
                when (destination.id) {
                    R.id.loginFragment -> showBottomNav()
                    R.id.exploreFragment -> showBottomNav()
                    else -> hideBottomNav()
                }
            }
        })
    }

    private fun showBottomNav() {
        binding.bottomNav.visibility = View.VISIBLE

    }

    private fun hideBottomNav() {
        binding.bottomNav.visibility = View.GONE

    }
}