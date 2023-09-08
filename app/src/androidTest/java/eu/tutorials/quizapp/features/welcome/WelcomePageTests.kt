package eu.tutorials.quizapp.features.welcome

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import eu.tutorials.quizapp.framework.data.Accounts
import eu.tutorials.quizapp.framework.data.Welcome
import eu.tutorials.quizapp.framework.testrule.FeatureTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class WelcomePageTests {

    @get:Rule
    val featureTestRule = FeatureTestRule()

    private val welcomePageActions = WelcomePageActions()

    @Test
    fun MA_T2_testNameIsNeededToContinue() {
        val validData = Welcome.validData

        welcomePageActions.apply{
            assertNameIsEmpty()
            pressStartButton()
            assertWelcomePageIsDisplayed(validData)
        }
    }

    @Test
    fun MA_T3_testEnterValidName() {
        val validUserData = Accounts.validName

        welcomePageActions.apply {
            enterName(validUserData)
            assertNameIsDisplayed(validUserData)
        }
    }

    @Test
    fun MA_T4_testWelcomePageIsDisplayed() {
        val validData = Welcome.validData

        welcomePageActions.assertWelcomePageIsDisplayed(validData)
    }
}