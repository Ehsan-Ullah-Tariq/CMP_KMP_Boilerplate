package domain.usecase

import domain.model.coin.CoinsDomainItem
import domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import utils.ApiResultResource

class GetCoinsUseCase(private val repository: CoinRepository) {
    operator fun invoke(page: Int, pageSize: Int): Flow<ApiResultResource<List<CoinsDomainItem>>> =
        repository.getCoins(page, pageSize)
}
