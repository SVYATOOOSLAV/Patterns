package basePatterns.behavioral.interpretator

fun main() {
    val isJava = getJavaExpression()
    val isJavaEE = getJavaEEExpression()

    println("Does developer knows java core: ${isJava.interpret("Java Core")}")
    println("Does developer knows java EE: ${isJavaEE.interpret("Java Spring")}")
}

fun getJavaExpression() : Expression{
    val java = TerminalExpression("Java")
    val javaCore = TerminalExpression("Java Core")

    return OrExpression(java, javaCore)
}

fun getJavaEEExpression() : Expression{
    val java = TerminalExpression("Java")
    val spring = TerminalExpression("Spring")

    return AndExpression(java, spring)
}

interface Expression {
    fun interpret(context: String): Boolean
}

class AndExpression(val expression1: Expression, val expression2: Expression) : Expression {
    override fun interpret(context: String): Boolean {
        return expression1.interpret(context) && expression2.interpret(context)
    }
}

class OrExpression(val expression1: Expression, val expression2: Expression) : Expression {
    override fun interpret(context: String): Boolean {
        return expression1.interpret(context) || expression2.interpret(context)
    }
}

class TerminalExpression(val data: String) : Expression {
    override fun interpret(context: String): Boolean {
        return context.contains(data)
    }
}