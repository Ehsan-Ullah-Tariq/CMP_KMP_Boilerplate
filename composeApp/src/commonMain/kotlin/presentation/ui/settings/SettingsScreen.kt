package presentation.ui.settings

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun SettingsScreen() {
    Text(
        "SettingsScreen",
        style = TextStyle(fontSize = 20.sp),
        modifier = Modifier.statusBarsPadding()
    )
}