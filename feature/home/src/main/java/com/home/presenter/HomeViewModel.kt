package com.home.presenter

import com.home.navigator.HomeToLogout
import core.view.BaseViewModel
import share.data.domain.GetUserUseCase
import share.navigation.FeatureRoute

class HomeViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val router: FeatureRoute
) : BaseViewModel<HomeEvent>() {

    fun onStart() {
        val user = getUserUseCase.execute()
        event.value = HomeEvent.Greeting("Hi ${user?.name ?: "***"}")
    }

    fun onLogout() {
        router.routeTo(HomeToLogout)
    }
}
