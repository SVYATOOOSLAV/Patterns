package basePatterns.structural.facade

fun main() {
    val workFlow = WorkFlow()
    workFlow.solveProblems()
}

class Job {
    fun doJob() = println("Job in progress")
}

class BugTracker {
    var activeSprint: Boolean = false

    fun startSpring() {
        println("Sprint is active")
        activeSprint = true
    }

    fun finishSprint() {
        println("Sprint is not active")
        activeSprint = false
    }
}

class Developer {
    fun doJobBeforeDeadline(bugTracker: BugTracker) {
        if (bugTracker.activeSprint) {
            println("Developer is sloving problems...")
        } else {
            println("Developer is reading a book")
        }
    }
}

//Facade
class WorkFlow{
    val developer = Developer()
    val job = Job()
    val bugTracker = BugTracker()

    fun solveProblems(){
        job.doJob()
        bugTracker.startSpring()
        developer.doJobBeforeDeadline(bugTracker)
    }
}