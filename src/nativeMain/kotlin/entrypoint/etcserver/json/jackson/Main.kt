package entrypoint.etcserver.json.jackson

import io.ktor.client.*
import io.ktor.client.engine.curl.*
import io.ktor.client.request.*
import io.ktor.utils.io.core.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

fun main() = runBlocking {
    val response: HelloMessage = HttpClient(Curl).use { client ->
        client.get {
            port = 8080
            url {
                path("/json/jackson")
            }
        }
    }
    val responseString = Json { allowStructuredMapKeys = true }.encodeToString(HelloMessage.serializer(), response)
    println(responseString)
}


@Serializable
data class HelloMessage(
    val hello: String
)
