package com.home.presenter.view

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.home.R
import com.home.databinding.FragmentHomeBinding
import com.home.presenter.HomeEvent
import com.home.presenter.HomeViewModel
import core.view.BaseFragment
import core.view.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named
import share.navigation.FeatureRoute

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        viewModel.onStart()
    }

    private fun initListener() {
        binding.logoutButton.setOnClickListener {
            viewModel.onLogout()
        }

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
        binding.toolbar.title = greeting.text
    }
}
