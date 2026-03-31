package di

import data.remote.api.ktorHttpClient
import io.ktor.client.HttpClient
import org.koin.dsl.module

fun networkModule()  = module {
    single<HttpClient> {
        ktorHttpClient
    }
}
