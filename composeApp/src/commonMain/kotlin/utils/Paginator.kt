package utils

import androidx.compose.runtime.Composable

class Paginator<T : Any>(
    private val initialPage: Int = 1,
    private val onLoadUpdated: (Boolean) -> Unit,
    private val onRequest: suspend (nextPage: Int) -> Result<List<T>>,
    private val getNextPage: suspend (currentPage: Int) -> Int,
    private val onError: suspend (Throwable?) -> Unit,
    private val onSuccess: suspend (items: List<T>, newPage: Int) -> Unit
) {
    private var currentPage = initialPage
    private var isLoading = false
    
    suspend fun loadNextItems() {
        if (isLoading) return
        
        isLoading = true
        onLoadUpdated(true)
        
        val result = onRequest(currentPage)
        
        isLoading = false
        onLoadUpdated(false)
        
        when {
            result.isSuccess -> {
                val items = result.getOrNull() ?: emptyList()
                currentPage = getNextPage(currentPage)
                onSuccess(items, currentPage)
            }
            result.isFailure -> {
                onError(result.exceptionOrNull())
            }
        }
    }
    
    fun reset() {
        currentPage = initialPage
    }
}
