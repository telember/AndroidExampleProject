package com.auth.data

import share.data.data.model.User

interface AuthService {
    suspend fun login(email: String, password: String): User?
    suspend fun register(email: String, password: String, confirmPassword: String): User?
}

class AuthServiceImpl : AuthService {
    override suspend fun login(email: String, password: String): User? {
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
