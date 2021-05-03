package com.auth.domain.login

import com.auth.data.AuthService
import com.auth.domain.login.model.LoginModel
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.mockito.Mockito.*
import share.data.data.model.User
import share.data.data.repository.AppRepository
import share.data.data.repository.AppRepositoryImpl

class LoginUseCaseTest {
    private val appRepository: AppRepository = AppRepositoryImpl()
    private val service: AuthService = mock(AuthService::class.java)

    @Test
    fun `test login success`() {
        //given
        val email = "email"
        val password = "password"
        val loginModel = LoginModel(email, password)
        val user = User("User01")

        runBlocking {
            doReturn(user).`when`(service).login(loginModel)
        }

        val loginUseCase = LoginUseCaseImpl(appRepository, service)

        var loginUser: User?

        // act
        runBlocking {
            loginUser = loginUseCase.execute(loginModel)
        }

        // assert
        assertEquals(user, loginUser)
        assertEquals(user, appRepository.user)
        runBlocking {
            verify(service, times(1)).login(loginModel)
        }
    }

    @Test
    fun `test login with empty login data`() {
        //given
        val email = ""
        val password = ""
        val loginModel = LoginModel(email, password)

        val loginUseCase = LoginUseCaseImpl(appRepository, service)

        var loginUser: User?

        // act
        runBlocking {
            loginUser = loginUseCase.execute(loginModel)
        }

        // assert
        assertNull(loginUser)
        runBlocking {
            verify(service, times(0)).login(loginModel)
        }
    }
}