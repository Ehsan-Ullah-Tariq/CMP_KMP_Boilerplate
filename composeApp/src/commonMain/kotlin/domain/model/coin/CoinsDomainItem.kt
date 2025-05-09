package domain.model.coin


import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Stable
@Serializable
data class CoinsDomainItem(
    @SerialName("current_price")
    val currentPrice: Double?,
    @SerialName("id")
    val id: String?,
    @SerialName("image")
    val image: String?,
    @SerialName("market_cap")
    val marketCap: Long?,
    @SerialName("market_cap_rank")
    val marketCapRank: Int?,
    @SerialName("name")
    val name: String?,
    @SerialName("symbol")
    val symbol: String?,
)