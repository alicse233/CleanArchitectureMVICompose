package app.mvicompose.data.remote.user_data

import kotlinx.serialization.Serializable

@Serializable
data class Id(
    val name: String,
    val value: String
)