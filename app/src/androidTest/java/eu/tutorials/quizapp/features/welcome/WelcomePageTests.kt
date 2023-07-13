package eu.tutorials.quizapp.features.welcome

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import eu.tutorials.quizapp.MainActivity
import eu.tutorials.quizapp.framework.data.Accounts
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class WelcomePageTests {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    private val welcomePageActions = WelcomePageActions()

    @Test
    fun testWelcomePage() {
        welcomePageActions.enterName(Accounts.validName)
        welcomePageActions.pressStartButton()
    }
}