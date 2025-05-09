package presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.model.coin.CoinsDomainItem
import domain.usecase.GetCoinsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import utils.ApiResultResource
import utils.UiStatesResource

class HomeViewModel(private val getCoinsUseCase: GetCoinsUseCase) : ViewModel() {

    private var currentPage = 1
    private val pageSize = 50
    private val _homeFeedUiState = MutableStateFlow<UiStatesResource<List<CoinsDomainItem>>>(UiStatesResource.Loading)
    val homeFeedUiState: StateFlow<UiStatesResource<List<CoinsDomainItem>>> = _homeFeedUiState.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = UiStatesResource.Loading
    )
    fun fetchHomeData() = viewModelScope.launch {
        getCoinsUseCase(currentPage, pageSize).collect { result ->
            when (result) {
                is ApiResultResource.Error -> {
                    _homeFeedUiState.value = UiStatesResource.Error(result.message)
                }

                ApiResultResource.Loading -> {
                    _homeFeedUiState.value = UiStatesResource.Loading
                }

                is ApiResultResource.Success -> {
                    _homeFeedUiState.value = UiStatesResource.Success(result.value)
                }
            }
        }
    }
}
