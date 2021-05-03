package com.auth.presenter.login

import com.auth.databinding.FragmentLoginBinding

interface LoginViewController {
    fun handleEvent(loginEvent: LoginEvent?, binding: FragmentLoginBinding)
}
