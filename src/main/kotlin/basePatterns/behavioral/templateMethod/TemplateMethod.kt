package basePatterns.behavioral.templateMethod

fun main() {
    val aA: AbstractClass = ConcreteClassA()
    aA.templateMethod()
    val aB: AbstractClass = ConcreteClassB()
    aB.templateMethod()
}

abstract class AbstractClass {
    abstract fun primitiveOperation1()
    abstract fun primitiveOperation2()

    fun templateMethod() {
        primitiveOperation1()
        primitiveOperation2()
        // do smth
        println()
    }
}

class ConcreteClassA : AbstractClass() {
    override fun primitiveOperation1() {
        println("ConcreteClassA.PrimitiveOperation1()")
    }

    override fun primitiveOperation2() {
        println("ConcreteClassA.PrimitiveOperation2()")
    }
}

class ConcreteClassB : AbstractClass() {
    override fun primitiveOperation1() {
        println("ConcreteClassB.PrimitiveOperation1()")
    }

    override fun primitiveOperation2() {
        println("ConcreteClassB.PrimitiveOperation2()")
    }
}