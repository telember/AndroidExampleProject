package com.auth.domain.login

import com.auth.data.AuthService
import com.auth.domain.login.model.LoginModel
import share.data.data.model.User
import share.data.data.repository.AppRepository

interface LoginUseCase {
    suspend fun execute(loginModel: LoginModel): User?
}

class LoginUseCaseImpl(
    private val appRepository: AppRepository,
    private val service: AuthService,
) : LoginUseCase {

    override suspend fun execute(loginModel: LoginModel): User? {
        return if (checkLoginCondition(loginModel)) {
            appRepository.user = service.login(loginModel)
            appRepository.user
        } else {
            null
        }
    }

    private fun checkLoginCondition(loginModel: LoginModel): Boolean {
        return loginModel.username.isNotEmpty() && loginModel.password.isNotEmpty()
    }
}
