package basePatterns.creational.abstractFabric

fun main(){
    val projectTeamFactory = TeamFactory()
    val developer = projectTeamFactory.getDeveloper()
    val tester = projectTeamFactory.getTester()
    val projectManager = projectTeamFactory.getProjectManager()

    developer.writeCode()
    tester.testCode()
    projectManager.manageProject()
}

interface Developer {
    fun writeCode()
}

interface Tester {
    fun testCode()
}

interface ProjectManager {
    fun manageProject()
}

// Создаем неограниченное число людей в команду
interface ProjectTeamFactory{
    fun getDeveloper() : Developer
    fun getTester() : Tester
    fun getProjectManager() : ProjectManager
}

class JavaDeveloper : Developer{
    override fun writeCode() {
        println("JavaDeveloper writes java code")
    }
}

class QATester : Tester{
    override fun testCode() {
        println("QA Tester test code")
    }
}

class ProjectManagerImpl : ProjectManager{
    override fun manageProject() {
        println("Project manager manages project")
    }
}

class TeamFactory : ProjectTeamFactory{
    override fun getDeveloper(): Developer = JavaDeveloper()
    override fun getTester(): Tester = QATester()
    override fun getProjectManager(): ProjectManager = ProjectManagerImpl()
}
