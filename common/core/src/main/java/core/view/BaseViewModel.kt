package core.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

open class BaseViewModel<T> : ViewModel() {

    val event = SingleLiveEvent<T>()

    fun onBackground(function: suspend () -> Unit) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                function.invoke()
            }
        }
    }

    fun postEvent(e: T) {
        event.postValue(e)
    }
}
