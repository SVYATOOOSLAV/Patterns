package basePatterns.behavioral.strategy

fun main(){
    val developer = Developer(Sleeping())
    developer.justDoIt()

    developer.activity = Training()
    developer.justDoIt()

    developer.activity = Coding()
    developer.justDoIt()

    developer.activity = Reading()
    developer.justDoIt()

    developer.activity = Sleeping()
    developer.justDoIt()
}

@FunctionalInterface
interface Activity{
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
    fun justDoIt(){
        activity.justDoIt()
    }
}