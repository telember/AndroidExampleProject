package com.auth.presenter.login.view

import android.os.Bundle
import android.view.View
import com.auth.R
import com.auth.databinding.FragmentLoginBinding
import com.auth.presenter.login.LoginEvent
import com.auth.presenter.login.LoginViewController
import com.auth.presenter.login.LoginViewModel
import core.view.BaseFragment
import core.view.viewBinding
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)
    private val viewModel: LoginViewModel by viewModel()
    private val view: LoginViewController = get()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        viewModel.event.observe(
            viewLifecycleOwner,
            ::handleEvent
        )
    }

    private fun handleEvent(loginEvent: LoginEvent?) {
        view.handleEvent(loginEvent, binding)
    }

    private fun initListener() {
        binding.registerButton.setOnClickListener {
            viewModel.performClickRegisterButton()
        }

        binding.loginButton.setOnClickListener {
            viewModel.performLogin(
                binding.email.text.toString(),
                binding.password.text.toString()
            )
        }
    }
}
