package basePatterns.behavioral.visitor

fun main() {
    val project = Project()
    val junior = JuniorDeveloper()
    val senior = SeniorDeveloper()

    project.beWritten(junior)
    project.beWritten(senior)
}

interface ProjectElement {
    fun beWritten(developer: Developer)
}

class Project : ProjectElement {
    private var projectElements: ArrayList<ProjectElement> = arrayListOf(
        ProjectClass(),
        Database(),
        Test()
    )

    override fun beWritten(developer: Developer) {
        projectElements.forEach {
            it.beWritten(developer)
        }
    }
}

class ProjectClass : ProjectElement {
    override fun beWritten(developer: Developer) {
        developer.create(this)
    }
}

class Database : ProjectElement {
    override fun beWritten(developer: Developer) {
        developer.create(this)
    }
}

class Test : ProjectElement {
    override fun beWritten(developer: Developer) {
        developer.create(this)
    }
}

interface Developer {
    fun create(projectClass: ProjectClass)
    fun create(database: Database)
    fun create(test: Test)
}

class JuniorDeveloper : Developer {
    override fun create(projectClass: ProjectClass) {
        println("Writing poor class...")
    }

    override fun create(database: Database) {
        println("Drop database...")
    }

    override fun create(test: Test) {
        println("Fall test...")
    }
}

class SeniorDeveloper : Developer {
    override fun create(projectClass: ProjectClass) {
        println("Writing good class...")
    }

    override fun create(database: Database) {
        println("Create database...")
    }

    override fun create(test: Test) {
        println("Good test...")
    }
}