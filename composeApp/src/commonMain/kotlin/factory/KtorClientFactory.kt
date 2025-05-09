package factory

import io.ktor.client.HttpClient

expect class KtorClientFactory {
    fun create(): HttpClient
}
