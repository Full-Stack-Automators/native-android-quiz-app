package eu.tutorials.quizapp.features.questions

import eu.tutorials.quizapp.framework.actions.EspressoAssertions
import eu.tutorials.quizapp.framework.actions.EspressoTouch
import eu.tutorials.quizapp.framework.data.Accounts
import eu.tutorials.quizapp.framework.data.Question
import eu.tutorials.quizapp.framework.data.Welcome

class QuestionPageActions {

    private val touch = EspressoTouch()
    private val assertion = EspressoAssertions()
    private val questionPageObject = QuestionPageObject()

    fun assertQuestionIsDisplayed(questionData: Question) {
        assertion.apply {
            assertTextIsDisplayed(questionPageObject.question, questionData.question)
            assertIsDisplayed(questionPageObject.image)
            assertTextIsDisplayed(questionPageObject.answerOne, questionData.answerOne)
            assertTextIsDisplayed(questionPageObject.answerTwo, questionData.answerTwo)
            assertTextIsDisplayed(questionPageObject.answerThree, questionData.answerThree)
            assertTextIsDisplayed(questionPageObject.answerFour, questionData.answerFour)
        }
    }
}