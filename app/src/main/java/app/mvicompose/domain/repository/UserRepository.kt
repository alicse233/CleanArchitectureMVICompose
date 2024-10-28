package app.mvicompose.domain.repository

import app.mvicompose.domain.model.User

interface UserRepository {
    suspend fun getRandomUser(): Result<User>
}