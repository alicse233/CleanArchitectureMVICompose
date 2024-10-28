package app.mvicompose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import app.mvicompose.presentation.error.ErrorScreen
import app.mvicompose.presentation.home.HomeScreen
import app.mvicompose.presentation.success.SuccessScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                navController = navController
            )
        }

        composable(
            "success/{username}",
            arguments = listOf(navArgument("username") { type = NavType.StringType })
        ) { backStackEntry ->
            SuccessScreen(backStackEntry.arguments?.getString("username") ?: "")
        }

        composable(
            "error/{error}",
            arguments = listOf(navArgument("error") { type = NavType.StringType })
        ) { backStackEntry ->
            ErrorScreen(backStackEntry.arguments?.getString("error") ?: "")
        }
    }
}