package basePatterns.behavioral.command

fun main() {
    val dataBase: Database = Database()
    val developerCommand: DeveloperCommand = DeveloperCommand(
        InsertCommand(dataBase),
        UpdateCommand(dataBase),
        SelectCommand(dataBase),
        DeleteCommand(dataBase),
    )
    developerCommand.insertRecord()
    developerCommand.updateRecord()
    developerCommand.selectRecord()
    developerCommand.deleteRecord()
}

class Database {
    fun insert() = println("Inserting record...")
    fun update() = println("Updating record....")
    fun select() = println("Reading record....")
    fun delete() = println("Deleting record...")
}

@FunctionalInterface
interface Command {
    fun execute()
}

class InsertCommand(val dataBase: Database) : Command {
    override fun execute() {
        dataBase.insert()
    }
}

class UpdateCommand(val dataBase: Database) : Command {
    override fun execute() {
        dataBase.update()
    }
}

class SelectCommand(val dataBase: Database) : Command {
    override fun execute() {
        dataBase.select()
    }
}

class DeleteCommand(val dataBase: Database) : Command {
    override fun execute() {
        dataBase.delete()
    }
}

class DeveloperCommand(
    val insert: Command,
    val update: Command,
    val select: Command,
    val delete: Command
) {
    fun insertRecord() = insert.execute()
    fun updateRecord() = update.execute()
    fun selectRecord() = select.execute()
    fun deleteRecord() = delete.execute()
}



