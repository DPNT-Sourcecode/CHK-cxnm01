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
                'A' -> finalPrice += (value / 3) * 130 + (value % 3) * 50
                'B' -> {
                    val amountOfE = mapSkuToQuantity['E']
                    val amountOfFreeBFromE = if(amountOfE == null) 0 else amountOfE / 2
                    val remainingB = value - amountOfFreeBFromE

                    if(amountOfE != null && remainingB > 0)
                        finalPrice += (remainingB / 2) * 45 + (remainingB % 2) * 30
                }
                'C' -> finalPrice += 20 * value
                'D' -> finalPrice += 15 * value
                'E' -> {
                    finalPrice += 40 * value
                    /*val amountOfB = mapSkuToQuantity['B']
                    if(amountOfB != null) {
                        finalPrice -= 30 * (value / 2)
                    }*/
                }
                else -> {
                    finalPrice = -1
                    break
                }
            }
        }

        return finalPrice
    }
}
