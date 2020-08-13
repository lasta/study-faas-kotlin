package entrypoint.greeting

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import message.greeting.Greeting
import service.greeting.GreetingService

fun main(args: Array<String>) {
    val greeting = GreetingService().greet(args)
    val greetingJsonString: String = Json(JsonConfiguration.Stable).stringify(Greeting.serializer(), greeting)
    println(greetingJsonString)
    val deserializedGreeting: Greeting = Json(JsonConfiguration.Stable).parse(Greeting.serializer(), greetingJsonString)
    println(deserializedGreeting)
}