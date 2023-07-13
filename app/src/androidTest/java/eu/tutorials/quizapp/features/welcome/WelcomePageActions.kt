package eu.tutorials.quizapp.features.welcome

import eu.tutorials.quizapp.framework.actions.Assertions
import eu.tutorials.quizapp.framework.actions.Touch
import eu.tutorials.quizapp.framework.data.Accounts

class WelcomePageActions {

    private val touch = Touch()
    private val assertion = Assertions()
    private val welcomePageObject = WelcomePageObject()

    fun enterName(userData: Accounts) {
        assertion.assertTextIsDisplayed(welcomePageObject.title, "Welcome")
        touch.typeText(welcomePageObject.inputTextfield, userData.name)
    }

    fun pressStartButton() {
        touch.click(welcomePageObject.startButton)
    }
}