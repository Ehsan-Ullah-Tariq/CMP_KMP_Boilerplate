package presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import config.AppConfig
import domain.model.coin.CoinsDomainItem
import domain.usecase.GetCoinsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import utils.ApiResultResource
import utils.UiStatesResource

class HomeViewModel(private val getCoinsUseCase: GetCoinsUseCase) : ViewModel() {

    private var currentPage = AppConfig.Coins.DEFAULT_PAGE //TODO need to implement pagination in future
    private val fetchHomeDataTrigger = MutableSharedFlow<Unit>(extraBufferCapacity = 1)

    @OptIn(ExperimentalCoroutinesApi::class)
    val homeFeedUiState: StateFlow<UiStatesResource<List<CoinsDomainItem>>> =
        fetchHomeDataTrigger
            .flatMapLatest { getCoinsUseCase(currentPage) }
            .map { result ->
                when (result) {
                    is ApiResultResource.Error -> UiStatesResource.Error(result.message)
                    ApiResultResource.Loading -> UiStatesResource.Loading
                    is ApiResultResource.Success -> UiStatesResource.Success(result.value)
                }
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Eagerly,
                initialValue = UiStatesResource.Loading
            )

    init {
        fetchHomeData()
    }

    fun fetchHomeData() {
        fetchHomeDataTrigger.tryEmit(Unit)
    }
}
