package data.remote.dto.homecoins


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinsApiRoi(
    @SerialName("currency")
    val currency: String?,
    @SerialName("percentage")
    val percentage: Double?,
    @SerialName("times")
    val times: Double?
)