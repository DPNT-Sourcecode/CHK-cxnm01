package solutions.CHK

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
        for((key, value) in mapSkuToQuantity) {
            when (key) {
                'A' -> {
                    var amountOfA = value

                    if(amountOfA / 5 > 0) {
                        finalPrice =+ (amountOfA / 5) * 200
                        amountOfA -= (amountOfA / 5)
                    }

                    if(amountOfA / 3 > 0) {
                        finalPrice =+ (amountOfA / 3) * 130
                        amountOfA -= (amountOfA / 3)
                    }

                    finalPrice += amountOfA * 50
                }
                'B' -> {
                    val amountOfE = mapSkuToQuantity['E']
                    val amountOfFreeBFromE = if(amountOfE == null) 0 else amountOfE / 2
                    val remainingB = value - amountOfFreeBFromE

                    if(amountOfE != null && remainingB > 0)
                        finalPrice += (remainingB / 2) * 45 + (remainingB % 2) * 30
                }
                'C' -> finalPrice += 20 * value
                'D' -> finalPrice += 15 * value
                'E' -> finalPrice += 40 * value
                else -> {
                    finalPrice = -1
                    break
                }
            }
        }

        return finalPrice
    }
}
