package solutions.CHK

import kotlin.math.min

object CheckoutSolution {
    fun checkout(skus: String): Int {
        val mapSkuToQuantity: MutableMap<Char, Int> = mutableMapOf()

        skus.forEach {
            run {
                val quantity = mapSkuToQuantity[it]
                if (quantity == null) mapSkuToQuantity[it] = 1
                else mapSkuToQuantity[it] = quantity + 1
            }
        }

        var finalPrice = 0;

        val amountOfS = mapSkuToQuantity['S'] ?: 0
        val amountOfT = mapSkuToQuantity['T'] ?: 0
        val amountOfX = mapSkuToQuantity['X'] ?: 0
        val amountOfY = mapSkuToQuantity['Y'] ?: 0
        val amountOfZ = mapSkuToQuantity['Z'] ?: 0

        val totalAmountOfMixedPackable = amountOfS + amountOfT + amountOfX + amountOfY + amountOfZ
        var (price, remaining) = packsOfNElements(totalAmountOfMixedPackable, 3,  45)
        finalPrice += price

        remaining = subtractAmountForPackedSKU(mapSkuToQuantity, 'Z', totalAmountOfMixedPackable - remaining)
        remaining = subtractAmountForPackedSKU(mapSkuToQuantity, 'S', remaining)
        remaining = subtractAmountForPackedSKU(mapSkuToQuantity, 'T', remaining)
        remaining = subtractAmountForPackedSKU(mapSkuToQuantity, 'Y', remaining)
        subtractAmountForPackedSKU(mapSkuToQuantity, 'X', remaining)

        for((key, value) in mapSkuToQuantity) {
            when (key) {
                'A' -> {
                    val (pricePack5, remainingPack5) = packsOfNElements(value, 5, 200)
                    finalPrice += pricePack5

                    val (pricePack3, remainingPack3) = packsOfNElements(remainingPack5, 3, 130)
                    finalPrice += pricePack3

                    finalPrice += remainingPack3 * 50
                }
                'B' -> {
                    val amountOfE = mapSkuToQuantity['E']
                    val amountOfFreeBFromE = if(amountOfE == null) 0 else amountOfE / 2
                    val remainingB = value - amountOfFreeBFromE

                    if(remainingB > 0)
                        finalPrice += (remainingB / 2) * 45 + (remainingB % 2) * 30
                }
                'C' -> finalPrice += 20 * value
                'D' -> finalPrice += 15 * value
                'E' -> finalPrice += 40 * value
                'F' -> {
                    val amountOfTripleFs = value / 3
                    finalPrice += 10 * (value - amountOfTripleFs)
                }
                'G' -> finalPrice += value * 20
                'H' -> {
                        val (pricePack10, remainingPack10) = packsOfNElements(value, 10, 80)
                        finalPrice += pricePack10

                        val (pricePack5, remainingPack5) = packsOfNElements(remainingPack10, 5, 45)
                        finalPrice += pricePack5

                        finalPrice += remainingPack5 * 10
                }
                'I' -> finalPrice += value * 35
                'J' -> finalPrice += value * 60
                'K' -> finalPrice += (value / 2) * 120 + (value % 2) * 70
                'L' -> finalPrice += value * 90
                'M' -> {
                    val amountOfN = mapSkuToQuantity['N']
                    val amountOfFreeMFromN = if(amountOfN == null) 0 else amountOfN / 3
                    val remainingM = value - amountOfFreeMFromN

                    if(remainingM > 0)
                        finalPrice += remainingM * 15
                }
                'N' -> finalPrice += value * 40
                'O' -> finalPrice += value * 10
                'P' -> finalPrice += (value / 5) * 200 + (value % 5) * 50
                'Q' -> {
                    val amountOfR = mapSkuToQuantity['R']
                    val amountOfFreeQFromR = if(amountOfR == null) 0 else amountOfR / 3
                    val remainingQ = value - amountOfFreeQFromR

                    if(remainingQ > 0)
                        finalPrice += (remainingQ / 3) * 80 + (remainingQ % 3) * 30
                }
                'R' -> finalPrice += value * 50
                'S' -> finalPrice += value * 20
                'T' -> finalPrice += value * 20
                'U' -> {
                    val amountOfTripleUs = value / 4
                    finalPrice += 40 * (value - amountOfTripleUs)
                }
                'V' -> {
                    val (pricePack3, remainingPack3) = packsOfNElements(value, 3, 130)
                    finalPrice += pricePack3

                    val (pricePack2, remainingPack2) = packsOfNElements(remainingPack3, 2, 90)
                    finalPrice += pricePack2

                    finalPrice += remainingPack2 * 50
                }
                'W' -> finalPrice += value * 20
                'X' -> finalPrice += value * 17
                'Y' -> finalPrice += value * 20
                'Z' -> finalPrice += value * 21
                else -> {
                    finalPrice = -1
                    break
                }
            }
        }

        return finalPrice
    }

    private fun packsOfNElements(amount: Int, packSize: Int, packPrice: Int): Pair<Int, Int> {
        return if(amount / packSize > 0)
            (amount / packSize) * packPrice to amount - (amount / packSize) * packSize
        else
            0 to amount
    }

    private fun subtractAmountForPackedSKU(shoppingCart: MutableMap<Char, Int>, char: Char, amountPacked: Int): Int {
        val amount = shoppingCart[char] ?: 0;
        if(amount > 0) {
            val valueToSubtract = min(amount, amountPacked)
            shoppingCart[char] = amount - valueToSubtract
            return amountPacked - valueToSubtract
        }
        return amountPacked
    }
}
