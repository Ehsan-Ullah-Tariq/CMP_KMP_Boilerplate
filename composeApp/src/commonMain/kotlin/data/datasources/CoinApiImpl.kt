package data.datasources

import data.remote.api.BASE_URL
import data.remote.api.CoinApi
import data.remote.dto.homecoins.CoinsApiItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class CoinApiImpl(private val client: HttpClient) : CoinApi {
    override suspend fun getCoins(page: Int,pageSize: Int): List<CoinsApiItem> {
        return client.get("${BASE_URL}/coins/markets") {
            parameter("vs_currency", "inr")
            parameter("order", "market_cap_desc")
            parameter("per_page", pageSize)
            parameter("page", page)
        }.body()
    }
}