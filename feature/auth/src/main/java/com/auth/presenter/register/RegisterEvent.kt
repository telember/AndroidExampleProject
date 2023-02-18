package com.auth.presenter.register

import share.data.data.model.User

sealed class RegisterEvent {
    object Loading : RegisterEvent()
    object RegisterError : RegisterEvent()
    class RegisterSuccess(val user: User) : RegisterEvent()
}
