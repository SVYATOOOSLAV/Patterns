package basePatterns

fun main() {
    val skills: Array<String> = arrayOf("Kotlin", "Git", "Docker", "Gradle", "PostgreSQL")
    val kotlinDeveloper = KotlinDeveloper("Qwerty", skills)
    val iterator = kotlinDeveloper.getIterator()

    println("Kotlin Developer: ${kotlinDeveloper.name}")
    print("Skills: ")
    while (iterator.hasNext()){
        print(iterator.next() + " ")
    }
}

interface Iterator<T> {
    fun hasNext(): Boolean
    fun next(): T
}

interface Collection<T> {
    fun getIterator(): Iterator<T>
}

data class KotlinDeveloper(
    val name: String,
    val skills: Array<String>
) : Collection<String> {

    override fun getIterator(): Iterator<String> = SkillIterator()

    inner class SkillIterator : Iterator<String> {
        private var index: Int = 0
        override fun hasNext(): Boolean = index < skills.size
        override fun next(): String = skills[index++]
    }
}
