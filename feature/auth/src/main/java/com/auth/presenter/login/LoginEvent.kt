package com.auth.presenter.login

sealed class LoginEvent {
    object Loading : LoginEvent()
    class LoginSuccess(val user: String) : LoginEvent()
    object LoginError : LoginEvent()
}
