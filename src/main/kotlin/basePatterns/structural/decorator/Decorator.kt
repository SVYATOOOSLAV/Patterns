package basePatterns.structural.decorator


fun main() {
    val developer = JavaTeamLead(SeniorJavaDeveloper(JavaDeveloper()))
    println(developer.makeJob())
}

interface Developer {
    fun makeJob(): String
}

class JavaDeveloper : Developer {
    override fun makeJob(): String {
        return "Write java code"
    }
}

class SeniorJavaDeveloper(developer: Developer) : DeveloperDecorator(developer) {
    private fun makeCodeReview() : String{
        return "\nMake code review"
    }

    override fun makeJob(): String {
        return super.makeJob() + makeCodeReview()
    }
}

class JavaTeamLead(developer: Developer) : DeveloperDecorator(developer){
    private fun sendWeekReport() : String{
        return "\nSend week report to Customer"
    }

    override fun makeJob(): String {
        return super.makeJob() + sendWeekReport()
    }
}

open class DeveloperDecorator(val developer: Developer) : Developer {
    override fun makeJob(): String {
        return developer.makeJob()
    }
}

