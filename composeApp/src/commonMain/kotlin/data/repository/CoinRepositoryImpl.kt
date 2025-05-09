package data.repository

import base.BaseRepository
import data.mapper.toCoinsDomainItem
import data.remote.api.CoinApi
import domain.model.coin.CoinsDomainItem
import domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import utils.ApiResultResource

class CoinRepositoryImpl(private val api: CoinApi) : CoinRepository, BaseRepository() {
    override fun getCoins(page: Int, pageSize: Int): Flow<ApiResultResource<List<CoinsDomainItem>>> {
        return safeApiCall {
            api.getCoins(page, pageSize).map { it.toCoinsDomainItem() }
        }
    }
}
