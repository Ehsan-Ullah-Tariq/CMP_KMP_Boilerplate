package data.datasources

import config.AppConfig
import data.remote.api.COIN_GECKO_BASE_URL
import data.remote.api.COIN_MARKETS_ENDPOINT
import data.remote.api.CoinApi
import data.remote.dto.homecoins.CoinsApiItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class CoinApiImpl(private val client: HttpClient) : CoinApi {
    override suspend fun getCoins(page: Int, pageSize: Int): List<CoinsApiItem> {
        return client.get("$COIN_GECKO_BASE_URL$COIN_MARKETS_ENDPOINT") {
            parameter("vs_currency", AppConfig.Coins.DEFAULT_VS_CURRENCY)
            parameter("order", AppConfig.Coins.DEFAULT_ORDER)
            parameter("per_page", pageSize)
            parameter("page", page)
        }.body()
    }
}
