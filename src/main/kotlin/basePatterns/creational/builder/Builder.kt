package basePatterns.creational.builder

data class Product(
    var field1: String? = null,
    var field2: String? = null,
    var field3: String? = null
)

class Builder(val product: Product = Product()) {

    fun changeField1(field: String): Builder {
        product.field1 = field
        return this
    }

    fun changeField2(field: String): Builder {
        product.field2 = field
        return this
    }

    fun changeField3(field: String): Builder {
        product.field3 = field
        return this
    }
}

fun main() {
    val builder = Builder()

    builder
        .changeField1("A")
        .changeField2("B")
        .changeField3("C")

    println(builder.product)
}