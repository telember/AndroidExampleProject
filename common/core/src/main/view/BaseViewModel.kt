package common.core.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

open class BaseViewModel<T>(private val dispatcher: CoroutineDispatcher) : ViewModel() {

    val event = SingleLiveEvent<T>()

    fun onBackground(function: suspend () -> Unit) {
        viewModelScope.launch {
            withContext(dispatcher) {
                function.invoke()
            }
        }
    }

    fun postEvent(e: T) {
        event.postValue(e)
    }
}
