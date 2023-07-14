package eu.tutorials.quizapp.framework.data

data class Welcome(
    val appTitle: String,
    val pageTitle: String,
    val description: String,
    val button: String
) {

    companion object {
        val validData = Welcome("Quiz App!", "Welcome", "Please enter your name.", "START")
        val invalidData = Welcome("dfgdg", "sdfgsfg", "sdfgsg", "sgsfgf")
    }
}
