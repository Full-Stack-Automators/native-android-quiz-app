package eu.tutorials.quizapp.framework.actions

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers

class EspressoTouch {

    fun typeText(elementId: Int, textToType: String) {
        Espresso.onView(ViewMatchers.withId(elementId))
            .perform(ViewActions.replaceText(textToType), ViewActions.closeSoftKeyboard())
    }

    fun click(elementId: Int) {
        Espresso.onView(ViewMatchers.withId(elementId))
            .perform(
                ViewActions.closeSoftKeyboard(), ViewActions.click()
            )
    }
}