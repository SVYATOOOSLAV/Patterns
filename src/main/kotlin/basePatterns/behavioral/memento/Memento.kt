package basePatterns.behavioral.memento

import java.util.*

fun main() {
    val project = Project()
    val githubRepo = GithubRepo()

    println("Creating new project. Version 1.0")
    project.version = "Version 1.0"
    println(project)

    println("Saving current version to github")
    githubRepo.save = project.save()

    Thread.sleep(5000)

    println("Updating project to version to 1.1")
    println("Writing poor code")
    project.version = "Version 1.1"
    println(project)

    println("Something went wrong")
    println("Rollback to stable version")
    project.load(githubRepo.save!!)

    println("Project after rollback")
    println(project)
}

class Project(private var date: Date = Date()) {
    var version: String = ""
        set(version) {
            field = version
            date = Date()
        }

    fun save(): Save = Save(version)

    fun load(save: Save) {
        version = save.version
        date = save.date
    }

    override fun toString(): String {
        return "Project(version='$version', date=$date)"
    }
}

class Save(
    val version: String,
    val date: Date = Date()
) {

}

class GithubRepo() {
    var save: Save? = null
}