package utils

import presentation.ui.navigation.BottomNavScreenState


object BottomNavRoutes {
    const val HOME = "Home"
    const val LIVE = "Live"
    const val SETTINGS = "Settings"
}


object FontFamilyTypes{
    const val LIGHT = "LIGHT"
    const val MEDIUM = "MEDIUM"
    const val BOLD = "BOLD"
}

val bottomNavItems = listOf(
    BottomNavScreenState.Home,
    BottomNavScreenState.Favourites,
    BottomNavScreenState.Profile,
)
