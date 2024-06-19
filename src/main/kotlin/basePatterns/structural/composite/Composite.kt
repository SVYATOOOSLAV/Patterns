package basePatterns.structural.composite

fun main(){
    val team = Team()
    val firstJavaDeveloper = JavaDeveloper()
    val secondJavaDeveloper = JavaDeveloper()
    val cppDeveloper = CppDeveloper()

    team.addDeveloper(firstJavaDeveloper)
    team.addDeveloper(secondJavaDeveloper)
    team.addDeveloper(cppDeveloper)

    team.writeCode()
}

interface Developer{
    fun writeCode()
}

class JavaDeveloper : Developer{
    override fun writeCode() {
        println("Java developer writes java code")
    }
}

class CppDeveloper : Developer{
    override fun writeCode() {
        println("Cpp developer writes C++ code")
    }
}

class Team : Developer{
    private val developers: ArrayList<Developer> = arrayListOf()

    fun addDeveloper(developer: Developer) = developers.add(developer)

    override fun writeCode() {
        println("Team creates project")
        developers.forEach { it.writeCode() }
    }
}