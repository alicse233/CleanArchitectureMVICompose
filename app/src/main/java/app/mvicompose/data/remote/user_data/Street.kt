package app.mvicompose.data.remote.user_data

import kotlinx.serialization.Serializable

@Serializable
data class Street(
    val name: String,
    val number: Int
)