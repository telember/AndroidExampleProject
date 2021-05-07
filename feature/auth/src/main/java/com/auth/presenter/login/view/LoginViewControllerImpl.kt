package com.auth.presenter.login.view

import android.view.View
import android.widget.Toast
import com.auth.databinding.FragmentLoginBinding
import com.auth.navigator.AuthToHome
import com.auth.presenter.login.LoginEvent
import com.auth.presenter.login.LoginViewController
import core.view.hideKeyboard
import share.navigation.FeatureRoute

class LoginViewControllerImpl: LoginViewController {
    override fun handleEvent(loginEvent: LoginEvent?, binding: FragmentLoginBinding) {
        binding.root.hideKeyboard()
        binding.warningText.visibility = View.GONE
        when (loginEvent) {
            is LoginEvent.Loading -> binding.loading.visibility = View.VISIBLE
            is LoginEvent.LoginSuccess -> {
                Toast.makeText(binding.root.context, "login success ${loginEvent.user}", Toast.LENGTH_SHORT).show()
                binding.loading.visibility = View.GONE
            }
            is LoginEvent.LoginError -> {
                binding.loading.visibility = View.GONE
                binding.warningText.visibility = View.VISIBLE
            }
            null -> binding.loading.visibility = View.GONE
        }
    }
}
