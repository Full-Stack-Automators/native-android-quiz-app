package eu.tutorials.quizapp.framework.data

data class Question(
    val question: String,
    val answerOne: String,
    val answerTwo: String,
    val answerThree: String,
    val answerFour: String,
) {

    companion object {
        val argentina = Question("What country does this flag belong to?", "Argentina", "Australia", "Armenia", "Austria")
    }
}
