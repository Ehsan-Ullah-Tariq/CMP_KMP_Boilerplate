package di

import data.datasources.CoinApiImpl
import data.remote.api.CoinApi
import data.repository.CoinRepositoryImpl
import domain.repository.CoinRepository
import domain.usecase.GetCoinsUseCase
import org.koin.dsl.module
import presentation.ui.home.HomeViewModel

fun commonModule() = module {
    single<CoinApi> { CoinApiImpl(get()) }
    single<CoinRepository> { CoinRepositoryImpl(get()) }
    factory { GetCoinsUseCase(get()) }
    factory { HomeViewModel(get()) }
}
