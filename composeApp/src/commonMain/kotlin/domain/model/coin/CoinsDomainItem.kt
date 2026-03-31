package domain.model.coin


import androidx.compose.runtime.Stable


@Stable
data class CoinsDomainItem(
    val currentPrice: Double?,
    val id: String?,
    val image: String?,
    val marketCap: Long?,
    val marketCapRank: Int?,
    val name: String?,
    val symbol: String?,
)