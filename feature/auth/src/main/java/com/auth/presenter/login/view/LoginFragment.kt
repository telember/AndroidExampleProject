package com.auth.presenter.login.view

import android.os.Bundle
import android.view.View
import com.auth.R
import com.auth.databinding.FragmentLoginBinding
import com.auth.presenter.login.LoginEvent
import com.auth.presenter.login.LoginViewController
import com.auth.presenter.login.LoginViewModel
import core.navigation.CrossRouter
import core.navigation.Router
import core.view.BaseFragment
import core.view.viewBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.activityRetainedScope
import org.koin.core.scope.Scope

class LoginFragment : BaseFragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)
    private lateinit var scope: Scope
    private val viewModel: LoginViewModel by lazy { scope.get() }
    private val view: LoginViewController by lazy { scope.get() }
    private val crossRouter: CrossRouter by inject()
    private val router: Router by lazy { scope.get() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scope = requireActivity().activityRetainedScope()

        router.crossRouter = crossRouter
        crossRouter.activity = requireActivity()
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
