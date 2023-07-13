package eu.tutorials.quizapp.framework.actions

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers

class Assertions {

    fun assertIsDisplayed(elementId: Int){
        Espresso.onView(ViewMatchers.withId(elementId))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun assertTextIsDisplayed(elementId: Int, expectedText: String){ // Works for snackbars - Not toasts
        Espresso.onView(ViewMatchers.withId(elementId))
            .check(ViewAssertions.matches(ViewMatchers.withText(expectedText)))
    }

    fun assertChildElementIsDisplayed(parentElementId: Int, childElementId: Int){
        Espresso.onView(ViewMatchers.withId(parentElementId))
            .check(
                ViewAssertions.matches(
                    ViewMatchers.hasDescendant(
                        ViewMatchers.withId(
                            childElementId
                        )
                    )
                )
            );
    }
}