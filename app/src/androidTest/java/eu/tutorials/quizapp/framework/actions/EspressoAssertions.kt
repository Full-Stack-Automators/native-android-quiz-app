package eu.tutorials.quizapp.framework.actions

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.isEmptyOrNullString

class EspressoAssertions {

    fun assertIsDisplayed(elementId: Int){
        onView(withId(elementId))
            .check(matches(isDisplayed()))
    }

    fun assertTextIsDisplayed(elementId: Int, expectedText: String){ // Works for snackbars - Not toasts
        onView(withId(elementId))
            .check(matches(withText(expectedText)))
    }

    fun assertElementIsEmpty(elementId: Int){
        onView(withId(elementId))
            .check(matches(withText(isEmptyOrNullString())))
    }

    fun assertChildElementIsDisplayed(parentElementId: Int, childElementId: Int){
        onView(withId(parentElementId))
            .check(
                matches(
                    hasDescendant(
                        withId(
                            childElementId
                        )
                    )
                )
            );
    }
}