package app.mvicompose.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import app.mvicompose.presentation.navigation.NavigationEvent
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    navController: NavController
) {
    val state by viewModel.state.collectAsState()
    
    LaunchedEffect(Unit) {
        viewModel.navigationEvents.collect { event ->
            when (event) {
                is NavigationEvent.ToSuccess -> {
                    navController.navigate("success/${event.username}")
                    viewModel.processIntent(HomeIntent.NavigatedToSuccess)
                }
                is NavigationEvent.ToError -> {
                    navController.navigate("error/${event.error}")
                    viewModel.processIntent(HomeIntent.NavigatedToError)
                }
            }
        }
    }
    
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (state.isLoading) {
            CircularProgressIndicator()
        } else {
            Button(
                onClick = { 
                    viewModel.processIntent(HomeIntent.LoadRandomUser)
                }
            ) {
                Text("Start")
            }
        }
    }
}