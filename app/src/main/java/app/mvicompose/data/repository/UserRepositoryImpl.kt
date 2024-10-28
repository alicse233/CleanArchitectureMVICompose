package app.mvicompose.data.repository

import app.mvicompose.data.remote.UserApi
import app.mvicompose.data.remote.user_data.toUser
import app.mvicompose.domain.model.User
import app.mvicompose.domain.repository.UserRepository

class UserRepositoryImpl(private val api: UserApi) : UserRepository {
    override suspend fun getRandomUser(): Result<User> = runCatching {
        api.getRandomUser().toUser()
    }
}