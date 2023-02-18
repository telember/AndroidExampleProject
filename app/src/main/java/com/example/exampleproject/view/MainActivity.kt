package com.example.exampleproject.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.exampleproject.databinding.ActivityMainBinding
import core.view.viewBinding

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
