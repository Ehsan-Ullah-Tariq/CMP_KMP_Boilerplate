import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.ui.SplashScreen

import presentation.ui.navigation.MainApplicationController
import presentation.ui.theme.MyAppTheme

@Composable
@Preview
fun App() {
    MyAppTheme(true) {
        var showSplashScreen by remember { mutableStateOf(true) }
        if (showSplashScreen) {
            SplashScreen(onNavigateToHome = { showSplashScreen = false })
        } else {
            MainApplicationController()
        }
    }
}

