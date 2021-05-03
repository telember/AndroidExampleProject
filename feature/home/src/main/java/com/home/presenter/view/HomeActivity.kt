package com.home.presenter.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.home.R
import com.home.databinding.ActivityHomeBinding
import com.home.presenter.HomeEvent
import com.home.presenter.HomeViewModel
import core.navigation.CrossRouter
import core.navigation.Router
import core.view.viewBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.activityRetainedScope
import org.koin.core.scope.Scope

class HomeActivity : AppCompatActivity() {

    private val scope: Scope by lazy { activityRetainedScope() }
    private val binding by viewBinding(ActivityHomeBinding::inflate)
    private lateinit var router: Router
    private val crossRouter: CrossRouter by inject()
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        initModule()
        initListener()
        viewModel.onStart()
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
        binding.toolbar.title = greeting.text
    }

    private fun initModule() {
        viewModel = scope.get()
        router = scope.get()
        router.crossRouter = crossRouter
        crossRouter.activity = this
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.onOptionSelected(item.itemId)
        return super.onOptionsItemSelected(item)
    }
}
