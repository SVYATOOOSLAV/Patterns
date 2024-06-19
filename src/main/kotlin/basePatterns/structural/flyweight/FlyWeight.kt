package basePatterns.structural.flyweight

fun main() {
    val developerFactory = DeveloperFactory()
    val developers: ArrayList<Developer> = arrayListOf()

    developers.add(developerFactory.getDeveloperBySpecialty("java"))
    developers.add(developerFactory.getDeveloperBySpecialty("java"))
    developers.add(developerFactory.getDeveloperBySpecialty("java"))
    developers.add(developerFactory.getDeveloperBySpecialty("c++"))
    developers.add(developerFactory.getDeveloperBySpecialty("c++"))

    developers.forEach { it.writeCode() }
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

//приспособленец
class DeveloperFactory {
    companion object {
        val developers: HashMap<String, Developer> = hashMapOf()
    }

    fun getDeveloperBySpecialty(specialty: String): Developer {
        var developer = developers[specialty]

        if (developer == null) {
            when (specialty) {
                "java" -> {
                    println("Нанимаем Java разработчика")
                    developer = JavaDeveloper()
                }

                "c++" -> {
                    println("Нанимаем C++ разработчика")
                    developer = CppDeveloper()
                }
            }
            developer?.let { developers.put(specialty, it) }
        }
        return developer!!
    }
}