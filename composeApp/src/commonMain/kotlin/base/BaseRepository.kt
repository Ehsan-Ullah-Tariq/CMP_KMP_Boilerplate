package base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import utils.ApiResultResource

abstract class BaseRepository {
    protected fun <T> safeApiCall(apiCall: suspend () -> T): Flow<ApiResultResource<T>> = flow {
        emit(ApiResultResource.Loading)
        try {
            val result = apiCall()
            emit(ApiResultResource.Success(result))
        } catch (e: Exception) {
            println(e.message)
            emit(ApiResultResource.Error(e.message ?: "Unknown Error"))
        }
    }
}
