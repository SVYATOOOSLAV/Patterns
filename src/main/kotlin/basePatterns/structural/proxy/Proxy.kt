package basePatterns.structural.proxy

fun main() {
    val project = ProxyProject("https://github.com/user/project")
    project.run()
}

interface Project {
    fun run()
}

class RealProject(private val url: String) : Project {

    init {
        load()
    }

    fun load() {
        println("Loading project from $url")
    }

    override fun run() {
        println("Running project $url")
    }

}

class ProxyProject(private val url: String) : Project {

    var realProject: RealProject? = null

    override fun run() {
        if (realProject == null) {
            realProject = RealProject(url)
        }
        realProject?.run()
    }
}