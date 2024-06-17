package basePatterns.behavioral.state

fun main() {
    val activity = Sleeping()
    val developer = Developer(activity)

    repeat((1..10).count()) {
        developer.justDoIt()
        developer.changeActivity()
    }
}

@FunctionalInterface
interface Activity {
    fun justDoIt()
}

class Coding : Activity {
    override fun justDoIt() = println("Writing code...")
}

class Reading : Activity {
    override fun justDoIt() = println("Reading book...")
}

class Sleeping : Activity {
    override fun justDoIt() = println("Sleeping...")
}

class Training : Activity {
    override fun justDoIt() = println("Training....")
}

class Developer(var activity: Activity) {
    fun changeActivity() {
        when (activity) {
            is Sleeping -> activity = Training()
            is Training -> activity = Coding()
            is Coding -> activity = Reading()
            is Reading -> activity = Sleeping()
        }
    }

    fun justDoIt() {
        activity.justDoIt()
    }
}