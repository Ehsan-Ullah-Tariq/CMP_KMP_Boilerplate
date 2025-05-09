package data.mapper

import data.remote.dto.homecoins.CoinsApiItem
import domain.model.coin.CoinsDomainItem

fun CoinsApiItem.toCoinsDomainItem(): CoinsDomainItem {
    return CoinsDomainItem(
        currentPrice = currentPrice,
        id = id,
        image = image,
        marketCap = marketCap,
        marketCapRank = marketCapRank,
        name = name,
        symbol = symbol
    )
}