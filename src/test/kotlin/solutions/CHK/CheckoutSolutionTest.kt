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

    @Test
    fun `Buy one B`() {
        Assertions.assertEquals(30, CheckoutSolution.checkout("B"))
    }

    @Test
    fun `Buy four A`() {
        Assertions.assertEquals(180, CheckoutSolution.checkout("AAAA"))
    }

    @Test
    fun `Buy eight A`() {
        Assertions.assertEquals(330, CheckoutSolution.checkout("AAAAAAAA"))
    }
}

/*
Result is: FAILED
Some requests have failed (4/40). Here are some of them:
 - {"method":"checkout","params":["AAAAAAAA"],"id":"CHK_R2_020"}, expected: 330, got: 130
 - {"method":"checkout","params":["AAAAAAAAA"],"id":"CHK_R2_021"}, expected: 380, got: 180
 - {"method":"checkout","params":["AAAAAEEBAAABB"],"id":"CHK_R2_040"}, expected: 455, got: 255
You have received a penalty of: 10 min
The round will restart now
*/
