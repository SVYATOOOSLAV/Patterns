package basePatterns.behavioral.observer

fun main() {
    val jobSite = KotlinDeveloperJobSite()
    jobSite.addVacancy("first vacancy")
    jobSite.addVacancy("second vacancy")

    jobSite.addObserver(Subscriber("first sub"))
    jobSite.addObserver(Subscriber("second sub"))

    jobSite.removeVacancy("second vacancy")
}

interface Observer {
    fun handleEvent(vacancies: List<String>)
}

interface Observed {
    fun addObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers()
}

class Subscriber(val name: String) : Observer {
    override fun handleEvent(vacancies: List<String>) {
        println("Dear $name we have updates in vacancies: $vacancies")
    }
}

class KotlinDeveloperJobSite : Observed {
    private val vacancies: ArrayList<String> = ArrayList<String>()
    private val subscribers: ArrayList<Observer> = ArrayList<Observer>()

    fun addVacancy(vacancy: String) {
        vacancies.add(vacancy)
        notifyObservers()
    }

    fun removeVacancy(vacancy: String) {
        vacancies.remove(vacancy)
        notifyObservers()
    }

    override fun addObserver(observer: Observer) {
        subscribers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        subscribers.remove(observer)
    }

    override fun notifyObservers() {
        subscribers.forEach { it.handleEvent(vacancies) }
    }
}

