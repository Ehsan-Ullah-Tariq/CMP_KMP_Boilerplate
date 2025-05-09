import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.ui.SplashScreen

import presentation.ui.main.MainScreen
import presentation.ui.theme.MyAppTheme

@Composable
@Preview
fun App() {
    MyAppTheme(true) {
        var showSplashScreen by remember { mutableStateOf(false) }
        if (showSplashScreen) {
            SplashScreen(onNavigateToHome = { showSplashScreen = false })
        } else {
            MainScreen()
        }
    }
}

