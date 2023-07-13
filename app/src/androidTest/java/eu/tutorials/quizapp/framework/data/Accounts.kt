package eu.tutorials.quizapp.framework.data

data class Accounts(val name: String = "") {

    companion object {
        val validName = Accounts(name = "Valid Name")
    }
}
