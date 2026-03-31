package presentation.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import utils.bottomNavItems
import org.jetbrains.compose.resources.painterResource

@Composable
fun MainApplicationController() {
    val navController = rememberNavController()
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        bottomBar = {
            NavigationBar(
                windowInsets = WindowInsets.navigationBars,
                modifier = Modifier
                    .height(100.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 15.dp,
                            topEnd = 15.dp,
                            bottomEnd = 0.dp,
                            bottomStart = 0.dp
                        )
                    )
                    .background(Color.Black),
            ) {
                BottomNav(navController = navController)
            }
        }
    ) { padding ->
        MainScreenNavigation(navController, padding)
    }
}

@Composable
fun RowScope.BottomNav(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination
    bottomNavItems.forEach { item ->
        NavigationBarItem(
            selected = currentRoute?.hierarchy?.any { it.route == item.route } == true,
            icon = {
                Image(
                    painter = painterResource(resource = if (currentRoute?.hierarchy?.any { it.route == item.route } == true) item.selectedIcon else item.unSelectedIcon),
                    contentDescription = item.label,
                    modifier = Modifier.size(20.dp)
                )
            },
            label = { Text(text = item.label) },
            onClick = {
                item.route.let { it1 ->
                    navController.navigate(it1) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.findStartDestination().route?.let {
                            popUpTo(it) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            }
        )
    }
}
