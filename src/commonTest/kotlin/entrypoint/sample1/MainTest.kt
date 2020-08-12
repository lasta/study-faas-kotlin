package entrypoint.sample1

import kotlin.test.Test
import kotlin.test.assertTrue

class MainTest {
    @Test
    fun testHello() {
        assertTrue("Kotlin/Native" in hello())
    }
}