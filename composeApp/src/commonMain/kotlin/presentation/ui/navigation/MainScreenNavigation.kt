package presentation.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import presentation.ui.live.LiveScreen
import presentation.ui.home.HomeScreen
import presentation.ui.settings.SettingsScreen

@Composable
fun MainScreenNavigation(navController: NavHostController, padding: PaddingValues) {
    NavHost(
        navController,
        startDestination = BottomNavScreenState.Home.route,
        modifier = Modifier.fillMaxSize().padding(padding)
    ) {
        composable(BottomNavScreenState.Home.route) {
            HomeScreen()
        }

        composable(BottomNavScreenState.Favourites.route) {
            LiveScreen()
        }

        composable(BottomNavScreenState.Profile.route) {
            SettingsScreen()
        }
    }
}