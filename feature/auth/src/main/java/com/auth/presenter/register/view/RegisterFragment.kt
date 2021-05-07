package com.auth.presenter.register.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.auth.R
import com.auth.databinding.FragmentRegisterBinding
import com.auth.presenter.register.RegisterEvent
import com.auth.presenter.register.RegisterViewModel
import core.view.BaseFragment
import core.view.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterFragment : BaseFragment(R.layout.fragment_register) {

    private val binding by viewBinding(FragmentRegisterBinding::bind)
    private val viewModel: RegisterViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
