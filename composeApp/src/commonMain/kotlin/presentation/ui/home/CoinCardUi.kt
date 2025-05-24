package presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.model.coin.CoinsDomainItem
import presentation.components.CenteredRow
import presentation.components.CommonText
import presentation.components.HorizontalSpacer
import presentation.components.RememberCachedImagePainter
import presentation.components.RoundedElevatedCard

@Composable
fun CoinCard(coinItem: CoinsDomainItem) {
    RoundedElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.fillMaxSize().padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            Box(
                modifier = Modifier.fillMaxWidth().height(100.dp),
                contentAlignment = Alignment.Center,
            ) {

                RememberCachedImagePainter(coinItem.image)
                CommonText(
                    text = "Hot!",
                    color = Color.White,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .background(Color.Red, shape = RoundedCornerShape(12.dp))
                        .padding(horizontal = 12.dp, vertical = 2.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
            }

            CenteredRow {
                CommonText(text = "Name: ", fontWeight = FontWeight.Bold)
                HorizontalSpacer(5.dp)
                CommonText(
                    text = "${coinItem.name}",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            CenteredRow {
                CommonText(text = "Current Price: ", fontWeight = FontWeight.Bold)
                HorizontalSpacer(5.dp)
                CommonText(text = "${coinItem.currentPrice}")
            }

            CenteredRow {
                CommonText(text = "Market Cap Rank: ", fontWeight = FontWeight.Bold)
                HorizontalSpacer(5.dp)
                CommonText(text = "${coinItem.marketCapRank}")
            }
        }
    }
}