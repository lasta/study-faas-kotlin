package message.greeting

import kotlinx.serialization.Serializable

@Serializable
data class Greeting(
    val name: String = "anonymous",
    val greeting: String = "Hello"
)