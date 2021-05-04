package com.auth.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.auth.R
import com.auth.databinding.ActivityAuthBinding
import core.view.viewBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.fragment.android.setupKoinFragmentFactory
import org.koin.androidx.scope.activityRetainedScope
import org.koin.core.KoinExperimentalAPI
import org.koin.core.scope.Scope
import share.navigation.CrossRouter
import share.navigation.Router

class AuthActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityAuthBinding::inflate)
    private val scope: Scope by lazy { activityRetainedScope() }
    private lateinit var router: Router
    private val crossRouter: CrossRouter by inject()

    @KoinExperimentalAPI
    override fun onCreate(savedInstanceState: Bundle?) {
        setupKoinFragmentFactory(scope)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        val inflater = navController.navInflater
        navController.graph = inflater.inflate(R.navigation.nav_auth)
        router = scope.get()
        router.navController = navController
        router.crossRouter = crossRouter
        crossRouter.activity = this
    }
}
