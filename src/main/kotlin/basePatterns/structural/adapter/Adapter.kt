package basePatterns.structural.adapter

fun main() {
    val database = AdapterJavaToDatabase()

    database.insert()
    database.update()
    database.select()
    database.delete()
}

interface Database {
    fun insert()
    fun update()
    fun select()
    fun delete()
}

open class JavaApplication {
    fun saveObject() = println("Saving java object")
    fun updateObject() = println("Updating java object")
    fun loadObject() = println("Loading java object")
    fun deleteObject() = println("Deleting java object")
}

class AdapterJavaToDatabase() : JavaApplication(), Database {
    override fun insert() {
        saveObject()
    }

    override fun update() {
        updateObject()
    }

    override fun select() {
        loadObject()
    }

    override fun delete() {
        deleteObject()
    }
}

