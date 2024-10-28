package app.mvicompose.data.remote.user_data

import kotlinx.serialization.Serializable

@Serializable
data class Info(
    val page: Int,
    val results: Int,
    val seed: String,
    val version: String
)