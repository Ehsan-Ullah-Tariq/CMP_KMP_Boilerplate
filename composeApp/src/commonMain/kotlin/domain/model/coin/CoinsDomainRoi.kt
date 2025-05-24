package domain.model.coin


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


data class CoinsDomainRoi(
    val currency: String?,
    val percentage: Double?,
    val times: Double?
)