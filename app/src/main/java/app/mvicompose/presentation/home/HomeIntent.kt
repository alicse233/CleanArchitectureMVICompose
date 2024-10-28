package app.mvicompose.presentation.home

sealed class HomeIntent {
    object LoadRandomUser : HomeIntent()
    object NavigatedToSuccess : HomeIntent()
    object NavigatedToError : HomeIntent()
}