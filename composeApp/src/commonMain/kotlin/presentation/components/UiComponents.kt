package presentation.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import kmp_boilerplate.composeapp.generated.resources.Res
import kmp_boilerplate.composeapp.generated.resources.ic_main_logo
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import presentation.ui.theme.PrimaryColor

@Composable
fun CommonToolbar(rowModifier: Modifier = Modifier, logoModifier: Modifier = Modifier) {
    Row(
        modifier = rowModifier.fillMaxWidth().height(60.dp)
            .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
            .background(color = PrimaryColor),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.ic_main_logo),
            contentDescription = "Logo",
            modifier = logoModifier.size(44.dp)
        )
    }
}

@Composable
fun GradientCircularProgressIndicator(
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    size: Dp = 48.dp,
    strokeWidth: Dp = 6.dp,
    gradientColors: List<Color> = listOf(Color(0xFF00C6FF), Color(0xFF0072FF)) // Blue gradient
) {
    if (isLoading) {
        val infiniteTransition = rememberInfiniteTransition(label = "LoadingAnim")
        val angleOffset = infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 360f,
            animationSpec = infiniteRepeatable(
                animation = tween(1000, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            ),
            label = "RotationAngle"
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Gray.copy(alpha = 0.3f), shape = RoundedCornerShape(20.dp)), // Optional dim background
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = modifier.size(size)) {
                val diameter = size.toPx()
                val stroke = strokeWidth.toPx()
                drawArc(
                    brush = Brush.sweepGradient(gradientColors),
                    startAngle = angleOffset.value,
                    sweepAngle = 270f,
                    useCenter = false,
                    size = Size(diameter, diameter),
                    topLeft = Offset(x = 0f, y = 0f),
                    style = Stroke(
                        width = stroke
                    )
                )
            }
        }
    }
}


@Composable
fun RememberCachedImagePainter(
    imageUrl: String?,
    placeholder: DrawableResource = Res.drawable.ic_main_logo,
    error: DrawableResource = Res.drawable.ic_main_logo
) {
    return AsyncImage(
        model = imageUrl,
        contentDescription = "image",
        placeholder = painterResource(placeholder),
        error = painterResource(error),
        contentScale = ContentScale.Fit,
    )
}

@Composable
fun RoundedElevatedCard(
    modifier: Modifier = Modifier,
    elevation: Dp = 8.dp,
    cornerRadius: Dp = 16.dp,
    containerColor: Color = Color.White,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = elevation),
        shape = RoundedCornerShape(cornerRadius),
        colors = CardDefaults.cardColors(containerColor = containerColor)
    ) {
        content()
    }
}



@Composable
fun CommonText(
    value: String,
    modifier: Modifier = Modifier,
    textSize: TextUnit = 12.sp,
    textStyle: TextStyle = TextStyle(),
    fontWeight: FontWeight = FontWeight.Normal
) {
    Text(
        text = value,
        color = Color.Black,
        fontSize = textSize,
        fontWeight = fontWeight,
        modifier = modifier,
        style = textStyle,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}


@Composable
fun VerticalSpacer(height: Dp) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun HorizontalSpacer(width: Dp) {
    Spacer(modifier = Modifier.width(width))
}

@Composable
fun ErrorText(modifier: Modifier = Modifier, error: String) {
    Text(text = error, style = TextStyle(color = Color.Red, fontSize = 12.sp))
}
