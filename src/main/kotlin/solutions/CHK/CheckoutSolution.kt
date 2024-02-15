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
            if (key < 'A' || key > 'D') {
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
        }

        return finalPrice
    }
}