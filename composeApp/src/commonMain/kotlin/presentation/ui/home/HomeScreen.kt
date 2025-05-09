package presentation.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import domain.model.coin.CoinsDomainItem
import org.koin.compose.viewmodel.koinViewModel
import presentation.components.CommonToolbar
import presentation.components.GradientCircularProgressIndicator
import utils.UiStatesResource

@Composable
fun HomeScreen(viewModel: HomeViewModel = koinViewModel()) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CommonToolbar(logoModifier = Modifier.padding(start = 10.dp, top = 5.dp))
        val homeData by viewModel.homeFeedUiState.collectAsStateWithLifecycle()
        LaunchedEffect(Unit) {
            if (homeData !is UiStatesResource.Success) viewModel.fetchHomeData()
        }
        SetCoinList(homeData)
    }
}

@Composable
private fun SetCoinList(homeData: UiStatesResource<List<CoinsDomainItem>>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when (homeData) {
            is UiStatesResource.Loading -> {
                GradientCircularProgressIndicator(
                    isLoading = true
                )
            }

            is UiStatesResource.Success -> {
                GradientCircularProgressIndicator(
                    isLoading = false
                )
                val response = homeData.value
                CoinListUi(response)
            }

            is UiStatesResource.Error -> {
                GradientCircularProgressIndicator(
                    isLoading = false
                )
                Text("Error: ${homeData.message}")
            }
        }
    }
}

@Composable
fun CoinListUi(dataList: List<CoinsDomainItem>) {
    val listState = rememberLazyGridState()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        state = listState,
        modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp)
    ) {
        items(dataList, key = { it.id ?: it.hashCode() }) { coin ->
            CoinCard(coin)
        }
    }
}




