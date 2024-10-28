package app.mvicompose.presentation.navigation

sealed class NavigationEvent {
    data class ToSuccess(val username: String) : NavigationEvent()
    data class ToError(val error: String) : NavigationEvent()
}