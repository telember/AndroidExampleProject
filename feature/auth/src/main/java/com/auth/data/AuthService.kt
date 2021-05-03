package com.auth.data

import com.auth.domain.login.model.LoginModel
import share.data.data.model.User

interface AuthService {
    suspend fun login(loginModel: LoginModel): User?
    suspend fun register(email: String, password: String, confirmPassword: String): User?
}

class AuthServiceImpl : AuthService {
    override suspend fun login(loginModel: LoginModel): User? {
        return User("test01")
    }

    override suspend fun register(
        email: String,
        password: String,
        confirmPassword: String
    ): User? {

        return null
    }
}
