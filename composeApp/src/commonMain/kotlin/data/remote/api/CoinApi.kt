package data.remote.api

import androidx.compose.foundation.pager.PageSize
import data.remote.dto.homecoins.CoinsApiItem

interface CoinApi {
    suspend fun getCoins(page: Int,pageSize: Int): List<CoinsApiItem>
}
