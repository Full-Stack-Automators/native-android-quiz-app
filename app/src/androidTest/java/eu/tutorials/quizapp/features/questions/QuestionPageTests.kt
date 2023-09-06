package eu.tutorials.quizapp.features.questions

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import eu.tutorials.quizapp.features.welcome.WelcomePageActions
import eu.tutorials.quizapp.framework.data.Question
import eu.tutorials.quizapp.framework.testrule.FeatureTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class QuestionPageTests {

    @get:Rule
    val featureTestRule = FeatureTestRule()

    private val welcomePageActions = WelcomePageActions()
    private val questionPageActions = QuestionPageActions()

    @Test
    fun MA_T1_testArgentinaQuestionIsDisplayed() {
        val argentina = Question.argentina

        welcomePageActions.navigateToQuestions()
        questionPageActions.assertQuestionIsDisplayed(argentina)
    }
}