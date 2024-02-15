package solutions.CHK

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CheckoutSolutionTest {

    @Test
    fun `Add three As`() {
        Assertions.assertEquals(130, CheckoutSolution.checkout("AAA"))
    }

    @Test
    fun `Add two Bs`() {
        Assertions.assertEquals(45, CheckoutSolution.checkout("BB"))
    }

    @Test
    fun `Add three As and two Bs`() {
        Assertions.assertEquals(175, CheckoutSolution.checkout("ABABA"))
    }

    @Test
    fun `Add three As and two Bs and a C`() {
        Assertions.assertEquals(195, CheckoutSolution.checkout("ABABAC"))
    }

    @Test
    fun `Add an invalid SKU`() {
        Assertions.assertEquals(-1, CheckoutSolution.checkout("X"))
    }

    @Test
    fun `Buy two Es`() {
        Assertions.assertEquals(80, CheckoutSolution.checkout("EE"))
    }

    @Test
    fun `Buy two Es and one B`() {
        Assertions.assertEquals(80, CheckoutSolution.checkout("EEB"))
    }

    @Test
    fun `Buy four Es and two B`() {
        Assertions.assertEquals(160, CheckoutSolution.checkout("EEEEBB"))
    }

    @Test
    fun `Buy three As, four Es and two B`() {
        Assertions.assertEquals(290, CheckoutSolution.checkout("AEEEAEBBA"))
    }
}
