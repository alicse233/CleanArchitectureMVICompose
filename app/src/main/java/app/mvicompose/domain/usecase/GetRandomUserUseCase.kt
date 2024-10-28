package app.mvicompose.domain.usecase

import app.mvicompose.domain.model.User
import app.mvicompose.domain.repository.UserRepository

class GetRandomUserUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(): Result<User> = repository.getRandomUser()
}