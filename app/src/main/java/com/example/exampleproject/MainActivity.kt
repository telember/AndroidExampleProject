package com.example.exampleproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.auth.R
import com.example.exampleproject.databinding.ActivityMainBinding
import core.view.viewBinding
import org.koin.android.ext.android.inject
import share.navigation.Router

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val router: Router by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        router.navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }
}