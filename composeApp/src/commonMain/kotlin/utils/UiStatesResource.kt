package utils

sealed class UiStatesResource<out T> {
    object Loading : UiStatesResource<Nothing>()
    data class Success<out T> (val value: T) : UiStatesResource<T>()
    data class Error(val message: String?) : UiStatesResource<Nothing>()
}
