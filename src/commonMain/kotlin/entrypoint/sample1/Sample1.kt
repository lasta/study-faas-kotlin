package entrypoint.sample1

import service.hello.hello
import service.hello.sum

fun main() {
    println(hello())

    val fortyTwo = sum(40, 2)
    println(fortyTwo)
}