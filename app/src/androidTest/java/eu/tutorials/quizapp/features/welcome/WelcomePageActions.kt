package eu.tutorials.quizapp.features.welcome

import eu.tutorials.quizapp.framework.actions.EspressoAssertions
import eu.tutorials.quizapp.framework.actions.EspressoTouch
import eu.tutorials.quizapp.framework.data.Accounts
import eu.tutorials.quizapp.framework.data.Welcome

class WelcomePageActions {

    private val touch = EspressoTouch()
    private val assertion = EspressoAssertions()
    private val welcomePageObject = WelcomePageObject()

    fun assertWelcomePageIsDisplayed(welcomeData: Welcome) {
        assertion.apply {
            assertTextIsDisplayed(welcomePageObject.appTitle, welcomeData.appTitle)
            assertTextIsDisplayed(welcomePageObject.pageTitle, welcomeData.pageTitle)
            assertTextIsDisplayed(welcomePageObject.description, welcomeData.description)
            assertTextIsDisplayed(welcomePageObject.startButton, welcomeData.button)
        }
    }

    fun navigateToQuestions() {
        enterName(Accounts.validName)
        pressStartButton()
    }

    fun assertNameIsDisplayed(userData: Accounts) {
        assertion.assertTextIsDisplayed(welcomePageObject.nameInput, userData.name)
    }

    fun assertNameIsEmpty() {
        assertion.assertElementIsEmpty(welcomePageObject.nameInput)
    }

    fun enterName(userData: Accounts) {
        touch.typeText(welcomePageObject.nameInput, userData.name)
    }

    fun pressStartButton() {
        touch.click(welcomePageObject.startButton)
    }
}