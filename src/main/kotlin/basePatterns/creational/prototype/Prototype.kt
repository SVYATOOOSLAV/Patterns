package basePatterns.creational.prototype

fun main() {
    val master = Project(1,"SuperProj", "val srcCode = SourceCode()")
    println(master)

    val factory = ProjectFactory(master)
    val masterClone = factory.cloneProject()
    println(masterClone)
}

interface Copyable {
    fun copy(): Any
}

data class Project(
    var id: Int,
    var projectName: String,
    var sourceCode: String
) : Copyable {

    override fun copy(): Any {
        val copy = Project(id, projectName, sourceCode)
        return copy
    }
}

class ProjectFactory(var project: Project) {
    fun cloneProject(): Project {
        return project.copy() as Project
    }
}