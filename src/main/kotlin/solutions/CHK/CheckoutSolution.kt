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

        val sum = 0;
        skus.forEach { entry -> {
            if(entry.key < 'A' || key > 'D')
        } }
    }
}