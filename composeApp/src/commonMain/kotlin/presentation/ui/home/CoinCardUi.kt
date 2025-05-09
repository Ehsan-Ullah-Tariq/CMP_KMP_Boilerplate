package presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.model.coin.CoinsDomainItem
import presentation.components.CommonText
import presentation.components.RememberCachedImagePainter
import presentation.components.RoundedElevatedCard
import presentation.components.VerticalSpacer

@Composable
fun CoinCard(coinItem: CoinsDomainItem) {
    RoundedElevatedCard(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Column(modifier = Modifier.fillMaxSize().padding(10.dp)) {
            Box(
                modifier = Modifier.fillMaxWidth().height(100.dp),
                contentAlignment = Alignment.Center
            ) {
                RememberCachedImagePainter(coinItem.image)
                Text(
                    text = "Hot!",
                    color = Color.White,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .background(Color.Red, shape = RoundedCornerShape(12.dp))
                        .padding(horizontal = 12.dp, vertical = 2.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
            }
            VerticalSpacer(10.dp)
            Row(modifier = Modifier.fillMaxWidth()) {
                CommonText(value = "Name: ", fontWeight = FontWeight.Bold)
                VerticalSpacer(5.dp)
                CommonText(value = "${coinItem.name}")
            }
            VerticalSpacer(10.dp)
            Row(modifier = Modifier.fillMaxWidth()) {
                CommonText(value = "Current Price: ", fontWeight = FontWeight.Bold)
                VerticalSpacer(5.dp)
                CommonText(value = "${coinItem.currentPrice}")
            }
            VerticalSpacer(10.dp)
            Row(modifier = Modifier.fillMaxWidth()) {
                CommonText(value = "Market Cap Rank: ", fontWeight = FontWeight.Bold)
                VerticalSpacer(5.dp)
                CommonText(value = "${coinItem.marketCapRank}")
            }
        }
    }
}