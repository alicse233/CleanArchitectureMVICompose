package app.mvicompose.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.mvicompose.domain.usecase.GetRandomUserUseCase
import app.mvicompose.presentation.navigation.NavigationEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getRandomUserUseCase: GetRandomUserUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    private val _navigationChannel = Channel<NavigationEvent>()
    val navigationEvents = _navigationChannel.receiveAsFlow()

    fun processIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.LoadRandomUser -> loadRandomUser()
            is HomeIntent.NavigatedToSuccess -> {
                _state.value = _state.value.copy(user = null)
            }
            is HomeIntent.NavigatedToError -> {
                _state.value = _state.value.copy(error = null)
            }
        }
    }

    private fun loadRandomUser() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            getRandomUserUseCase()
                .onSuccess { user ->
                    _state.value = _state.value.copy(
                        isLoading = false,
                        user = user,
                        error = null
                    )
                    _navigationChannel.send(NavigationEvent.ToSuccess(user.name))
                }
                .onFailure { exception ->
                    _state.value = _state.value.copy(
                        isLoading = false,
                        error = exception.message
                    )
                    _navigationChannel.send(NavigationEvent.ToError(exception.message ?: "Unknown error"))
                }
        }
    }
}