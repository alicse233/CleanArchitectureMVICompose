package app.mvicompose.data.remote.user_data

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val city: String,
    val coordinates: Coordinates,
    val country: String,
    val postcode: Int,
    val state: String,
    val street: Street,
    val timezone: Timezone
)