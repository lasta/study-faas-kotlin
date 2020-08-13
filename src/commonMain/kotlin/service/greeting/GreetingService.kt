package service.greeting

import message.greeting.Greeting

class GreetingService {

    fun greet(args: Array<String>): Greeting {
        if (args.size != 2) {
            return Greeting()
        }
        return Greeting(name = args[0], greeting = args[1])
    }
}