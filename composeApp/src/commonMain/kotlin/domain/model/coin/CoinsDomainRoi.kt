package domain.model.coin


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinsDomainRoi(
    @SerialName("currency")
    val currency: String?,
    @SerialName("percentage")
    val percentage: Double?,
    @SerialName("times")
    val times: Double?
)