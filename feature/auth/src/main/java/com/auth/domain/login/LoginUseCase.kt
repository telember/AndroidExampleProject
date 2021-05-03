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
  private val service: AuthService
) : LoginUseCase {

  override suspend fun execute(loginModel: LoginModel): User? {
    appRepository.user = service.login(loginModel.username, loginModel.password)
    return appRepository.user
  }

}