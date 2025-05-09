package utils

sealed class ApiResultResource<out T> {
    object Loading : ApiResultResource<Nothing>()
    data class Success<out T> (val value: T) : ApiResultResource<T>()
    data class Error(val message: String?) : ApiResultResource<Nothing>()
}
