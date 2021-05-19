package com.explore.view

import android.os.Bundle
import android.view.View
import com.explore.R
import com.explore.databinding.FragmentExploreBinding
import core.view.BaseFragment
import core.view.viewBinding
import org.koin.android.ext.android.get
import share.navigation.GlobalDestination
import share.navigation.Router

class ExploreFragment : BaseFragment(R.layout.fragment_explore){
    private val binding by viewBinding(FragmentExploreBinding::bind)
    val router: Router = get()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginButton.setOnClickListener {
            router.routeToNavFlow(GlobalDestination.AuthNav)
        }
    }
}