package entrypoint.greeting

import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import message.greeting.Greeting
import service.greeting.GreetingService

@UnstableDefault
fun main(args: Array<String>) {
    val greeting = GreetingService().greet(args)
    println(Json.stringify(Greeting.serializer(), greeting))
}