package Clases

class UserRepository(val usersList : List<User> = listOf(
    User("Juan", "123456789"),
    User("Diego", "987654321"),
    User("Cristian", "SoyUnaContraseña"))
    ) {

    fun getUsers() = usersList

    fun getUser(usuario : String) : User? {

        for (i in usersList.indices) {
            if (usersList[i].userName == usuario) {
                return usersList[i]
            }
        }

        return null
    }

    fun validateUser(user : String, password : String) : Boolean = User(user, password) in usersList
}