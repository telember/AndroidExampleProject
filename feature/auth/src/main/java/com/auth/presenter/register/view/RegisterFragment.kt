package com.auth.presenter.register.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.auth.R
import com.auth.databinding.FragmentRegisterBinding
import com.auth.presenter.register.RegisterEvent
import com.auth.presenter.register.RegisterViewModel
import core.navigation.CrossRouter
import core.navigation.Router
import core.view.BaseFragment
import core.view.viewBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.activityRetainedScope
import org.koin.core.scope.Scope

class RegisterFragment : BaseFragment(R.layout.fragment_register) {

    private val binding by viewBinding(FragmentRegisterBinding::bind)
    private lateinit var scope: Scope
    private val viewModel: RegisterViewModel by lazy { scope.get() }
    private val crossRouter: CrossRouter by inject()
    private val router: Router by lazy { scope.get() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scope = requireActivity().activityRetainedScope()
        router.crossRouter = crossRouter
        crossRouter.activity = requireActivity()
        binding.loginButton.setOnClickListener {
            viewModel.performClickLogin()
        }
        viewModel.event.observe(this, ::handleEvent)
        initListener()
    }

    private fun initListener() {
        binding.registerButton.setOnClickListener {
            viewModel.performRegister(
                email = binding.emailText.text.toString(),
                password = binding.passwordText.text.toString(),
                confirmPassword = binding.repasswordText.text.toString()
            )
        }
    }

    private fun handleEvent(registerEvent: RegisterEvent?) {
        binding.warningText.visibility = View.GONE
        when (registerEvent) {
            RegisterEvent.Loading -> binding.loading.visibility = View.VISIBLE
            RegisterEvent.RegisterError -> {
                binding.loading.visibility = View.GONE
                binding.warningText.visibility = View.VISIBLE
            }
            is RegisterEvent.RegisterSuccess -> {
                Toast.makeText(requireContext(), registerEvent.user.name, Toast.LENGTH_LONG).show()
                binding.loading.visibility = View.GONE
            }
            null -> binding.loading.visibility = View.GONE
        }
    }
}
