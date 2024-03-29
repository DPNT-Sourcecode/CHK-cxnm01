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
    fun `Buy three As, four Es and two Bs`() {
        Assertions.assertEquals(290, CheckoutSolution.checkout("AEEEAEBBA"))
    }

    @Test
    fun `Buy one B`() {
        Assertions.assertEquals(30, CheckoutSolution.checkout("B"))
    }

    @Test
    fun `Buy four As`() {
        Assertions.assertEquals(180, CheckoutSolution.checkout("AAAA"))
    }

    @Test
    fun `Buy eight As`() {
        Assertions.assertEquals(330, CheckoutSolution.checkout("AAAAAAAA"))
    }

    @Test
    fun `Buy nine As`() {
        Assertions.assertEquals(380, CheckoutSolution.checkout("AAAAAAAAA"))
    }

    @Test
    fun `Buy eight As, two Es and two Bs`() {
        Assertions.assertEquals(455, CheckoutSolution.checkout("AAAAAEEBAAABB"))
    }

    @Test
    fun `Buy three Fs`() {
        Assertions.assertEquals(20, CheckoutSolution.checkout("FFF"))
    }

    @Test
    fun `Buy two Fs`() {
        Assertions.assertEquals(20, CheckoutSolution.checkout("FF"))
    }

    @Test
    fun `Buy six Fs`() {
        Assertions.assertEquals(40, CheckoutSolution.checkout("FFFFFF"))
    }

    @Test
    fun `Buy seven Fs`() {
        Assertions.assertEquals(50, CheckoutSolution.checkout("FFFFFFF"))
    }

    @Test
    fun `Buy tree Us`() {
        Assertions.assertEquals(120, CheckoutSolution.checkout("UUU"))
    }

    @Test
    fun `Buy two Vs`() {
        Assertions.assertEquals(90, CheckoutSolution.checkout("VV"))
    }

    @Test
    fun `Buy five Vs`() {
        Assertions.assertEquals(220, CheckoutSolution.checkout("VVVVV"))
    }

    @Test
    fun `Buy four Zs`() {
        Assertions.assertEquals(66, CheckoutSolution.checkout("ZZZZ"))
    }

    @Test
    fun `Buy ZXT`() {
        Assertions.assertEquals(45, CheckoutSolution.checkout("ZXT"))
    }

    @Test
    fun `Buy AAAZZZ`() {
        Assertions.assertEquals(175, CheckoutSolution.checkout("AAAZZZ"))
    }
}

