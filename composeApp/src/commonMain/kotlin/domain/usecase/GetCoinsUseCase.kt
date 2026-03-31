package domain.usecase

import config.AppConfig
import domain.model.coin.CoinsDomainItem
import domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import utils.ApiResultResource

class GetCoinsUseCase(private val repository: CoinRepository) {
    operator fun invoke(
        page: Int,
        pageSize: Int = AppConfig.Coins.DEFAULT_PAGE_SIZE
    ): Flow<ApiResultResource<List<CoinsDomainItem>>> =
        repository.getCoins(page, pageSize)
}
