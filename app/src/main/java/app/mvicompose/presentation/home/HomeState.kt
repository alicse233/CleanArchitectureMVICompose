package app.mvicompose.presentation.home

import app.mvicompose.domain.model.User

data class HomeState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val user: User? = null
)