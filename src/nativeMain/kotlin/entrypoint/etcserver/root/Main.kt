package entrypoint.etcserver.root

import io.ktor.client.*
import io.ktor.client.engine.curl.*
import io.ktor.client.request.*
import io.ktor.utils.io.core.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val response: String = HttpClient(Curl).use { client ->
        client.get {
            port = 8080
        }
    }
    println(response)
}
