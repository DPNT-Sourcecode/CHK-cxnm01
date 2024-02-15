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
                'B' -> finalPrice += (value / 2) * 45 + (value % 2) * 30
                'C' -> finalPrice += 20 * value
                'D' -> finalPrice += 15 * value
//                'E' -> finalPrice += (value / 3) * 130 + (value % 3) * 50
                else -> {
                    finalPrice = -1
                    break
                }
            }

            /*if (key < 'A' || key > 'E') {
                finalPrice = -1
                break
            }
            if(key == 'A') {
                finalPrice += (value / 3) * 130 + (value % 3) * 50
            }
            if(key == 'B') {
                finalPrice += (value / 2) * 45 + (value % 2) * 30
            }
            if(key == 'C') {
                finalPrice += 20 * value
            }
            if(key == 'D') {
                finalPrice += 15 * value
            }
            if(key == 'E') {

            }*/
        }

        return finalPrice
    }
}
