package app.mvicompose.data.remote.user_data

import app.mvicompose.domain.model.User
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val info: Info,
    val results: List<Result>
)

fun UserDto.toUser(): User {
    val results = this.results
    return User(
        title = this.results.firstOrNull()?.id?.value ?: "",
        name =
        buildString {
            append((results.firstOrNull()?.name?.title ?: "-"))
            append(" ")
            append((results.firstOrNull()?.name?.first ?: "-"))
            append(" ")
            append((results.firstOrNull()?.name?.last ?: "-"))
            append(" ")
        }
    )
}