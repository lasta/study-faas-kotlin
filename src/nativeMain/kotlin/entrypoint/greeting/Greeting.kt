package entrypoint.greeting

import kotlinx.serialization.json.Json
import message.greeting.Greeting
import service.greeting.GreetingService

fun main(args: Array<String>) {
    val greeting = GreetingService().greet(args)
    val greetingJsonString: String =
        Json { allowStructuredMapKeys = true }.encodeToString(Greeting.serializer(), greeting)
    println(greetingJsonString)
    val deserializedGreeting: Greeting =
        Json { allowStructuredMapKeys = true }.decodeFromString(Greeting.serializer(), greetingJsonString)
    println(deserializedGreeting)
}
