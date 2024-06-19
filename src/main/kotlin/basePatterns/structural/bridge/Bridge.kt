package basePatterns.structural.bridge

fun main() {
    var programs = arrayOf(BankSystem(JavaDeveloper()))
    programs.forEach { it.developerProgram() }

    programs = arrayOf(BankSystem(CppDeveloper()))
    programs.forEach { it.developerProgram() }
}

abstract class Program(protected val developer: Developer) {
    abstract fun developerProgram()
}

interface Developer {
    fun writeCode()
}

class JavaDeveloper : Developer {
    override fun writeCode() {
        println("Java developer writes java code")
    }
}

class CppDeveloper : Developer {
    override fun writeCode() {
        println("Cpp developer writes C++ code")
    }
}

class BankSystem(developer: Developer) : Program(developer) {
    override fun developerProgram() {
        println("Bank system development in progress")
        developer.writeCode()
    }
}