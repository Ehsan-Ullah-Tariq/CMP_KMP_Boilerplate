package domain.repository

import domain.model.coin.CoinsDomainItem
import kotlinx.coroutines.flow.Flow
import utils.ApiResultResource

interface CoinRepository {
    fun getCoins(page: Int,pageSize: Int): Flow<ApiResultResource<List<CoinsDomainItem>>>
}
