package basePatterns.creational.fabricMethod

interface Product

class ConcreteProductA : Product
class ConcreteProductB : Product

interface Creator {
    fun factoryMethod(): Product
}

class ConcreteCreatorA : Creator {
    override fun factoryMethod(): Product = ConcreteProductA()
}

class ConcreteCreatorB : Creator {
    override fun factoryMethod(): Product = ConcreteProductB()
}