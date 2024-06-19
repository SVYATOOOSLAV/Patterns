package basePatterns.behavioral.mediator

fun main(){
    val chat = SimpleTextChat()

    val admin = Admin(chat, "admin")
    val user1 = SimpleUser(chat, "user 1")
    val user2 = SimpleUser(chat, "user 2")

    chat.admin = admin
    chat.addUserToChat(user1)
    chat.addUserToChat(user2)

    user1.sendMessage("Hello, I'm user 1")
    admin.sendMessage("Hello, I'm administrator")
}
// Медиатор
interface Chat {
    fun sendMessage(message: String, user: User)
}

interface User {
    fun sendMessage(message: String)
    fun getMessage(message: String)
}

class Admin(val chat: Chat, val name: String) : User {

    override fun sendMessage(message: String) {
        chat.sendMessage(message, this)
    }

    override fun getMessage(message: String) {
        println("$name receiving message $message")
    }
}

class SimpleUser(val chat: Chat, val name: String) : User {

    override fun sendMessage(message: String) {
        chat.sendMessage(message, this)
    }

    override fun getMessage(message: String) {
        println("$name receiving message $message")
    }
}

class SimpleTextChat() : Chat {
    lateinit var admin: User
    var users: ArrayList<User> = arrayListOf()

    fun addUserToChat(user: User) {
        users.add(user)
    }

    override fun sendMessage(message: String, user: User) {
        users.forEach { u ->
            if (u != user){
                u.getMessage(message)
            }
        }
        admin.getMessage(message)
    }
}