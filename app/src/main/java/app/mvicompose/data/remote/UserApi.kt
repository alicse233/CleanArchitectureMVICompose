package app.mvicompose.data.remote

import app.mvicompose.data.remote.user_data.UserDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class UserApi(private val client: HttpClient) {
    suspend fun getRandomUser(): UserDto {
        return client.get("https://api.randomuser.me/").body()
    }
}