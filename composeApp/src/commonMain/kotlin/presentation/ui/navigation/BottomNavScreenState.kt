package presentation.ui.navigation

import kmp_boilerplate.composeapp.generated.resources.Res
import kmp_boilerplate.composeapp.generated.resources.ic_home
import kmp_boilerplate.composeapp.generated.resources.ic_live
import kmp_boilerplate.composeapp.generated.resources.ic_settings
import org.jetbrains.compose.resources.DrawableResource
import utils.BottomNavRoutes


sealed class BottomNavScreenState(
    val label: String,
    val selectedIcon: DrawableResource,
    val unSelectedIcon: DrawableResource,
    val route: String,
    val badgeCount: Int? = null,
) {
    data object Home : BottomNavScreenState(
        label = "Home",
        selectedIcon = Res.drawable.ic_home,
        unSelectedIcon = Res.drawable.ic_home,
        route = BottomNavRoutes.HOME,
    )

    data object Favourites : BottomNavScreenState(
        label = "Live",
        selectedIcon = Res.drawable.ic_live,
        unSelectedIcon = Res.drawable.ic_live,
        route = BottomNavRoutes.LIVE
    )

    data object Profile : BottomNavScreenState(
        label = "Settings",
        selectedIcon = Res.drawable.ic_settings,
        unSelectedIcon = Res.drawable.ic_settings,
        route = BottomNavRoutes.SETTINGS
    )
}
