package di

import data.remote.api.httpClient
import io.ktor.client.HttpClient
import org.koin.dsl.module

fun networkModule()  = module {
    single<HttpClient> {
        httpClient
    }
}