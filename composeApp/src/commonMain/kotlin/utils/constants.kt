package utils

import presentation.ui.main.bottomnavigation.BottomNavScreenState


object BottomNavRoutes {
    const val HOME = "Home"
    const val LIVE = "Live"
    const val SETTINGS = "Settings"
}

val bottomNavItems = listOf(
    BottomNavScreenState.Home,
    BottomNavScreenState.Favourites,
    BottomNavScreenState.Profile,
)
