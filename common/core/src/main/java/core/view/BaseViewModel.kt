package core.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

open class BaseViewModel<T> : ViewModel() {

    val event = SingleLiveEvent<T>()

    fun launchDataLoad(function: suspend () -> Unit,
                       failureFallback: (Throwable) -> Unit = {}) {
        viewModelScope.launch {
            runCatching {
                function.invoke()
            }.onFailure {
                failureFallback.invoke(it)
            }
        }
    }

    fun postEvent(e: T) {
        event.postValue(e)
    }
}
