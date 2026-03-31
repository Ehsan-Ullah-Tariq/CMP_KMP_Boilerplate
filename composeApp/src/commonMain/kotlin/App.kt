import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
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

