package com.home.presenter

sealed class HomeEvent {
    data class Greeting(val text: String) : HomeEvent()
    object Loading : HomeEvent()
    object LoadError : HomeEvent()
    object EmptyList : HomeEvent()
}
