package service.hello

import kotlin.test.Test
import kotlin.test.assertEquals

class HelloFunctionKtTest {

    @Test
    fun testHelloWorld() = assertEquals("Hello, Kotlin/Native!", hello())

    @Test
    fun testSum() = assertEquals(3, sum(1, 2))
}