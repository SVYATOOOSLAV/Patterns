package basePatterns.behavioral.chain

fun main(){
    val reportNotifier = SimpleReportNotifier(Priority.ROUTINE.ordinal)
    val emailNotifier = EmailNotifier(Priority.IMPORTANT.ordinal)
    val smsNotifier = SMSNotifier(Priority.ASAP.ordinal)

    reportNotifier.nextNotifier = emailNotifier
    emailNotifier.nextNotifier = smsNotifier

    reportNotifier.notifyManager("Everything is ok", Priority.ROUTINE.ordinal)
    reportNotifier.notifyManager("Something went wrong", Priority.IMPORTANT.ordinal)
    reportNotifier.notifyManager("We have problems", Priority.ASAP.ordinal)
}

abstract class Notifier(var priority: Int){
    var nextNotifier: Notifier? = null

    fun notifyManager(message: String, level: Int){
        if(level >= priority){
            write(message)
        }
        nextNotifier?.notifyManager(message, level)
    }

    abstract fun write(message: String)
}

enum class Priority(level: Int){
    ROUTINE(1),
    IMPORTANT(2),
    ASAP(3),
}

class SimpleReportNotifier(priority: Int) : Notifier(priority){
    override fun write(message: String) {
        println("Notifying using simple report $message")
    }
}

class EmailNotifier(priority: Int) : Notifier(priority){
    override fun write(message: String) {
        println("Notifying using email $message")
    }
}

class SMSNotifier(priority: Int) : Notifier(priority){
    override fun write(message: String) {
        println("Notifying using sms $message")
    }
}