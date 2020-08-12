package sample

fun hello(): String = "Hello, Kotlin/Native!"

fun sum(a: Int, b: Int): Int = a + b

fun main() {
    println(hello())

    val fortyTwo = sum(40, 2)
    println(fortyTwo)
}