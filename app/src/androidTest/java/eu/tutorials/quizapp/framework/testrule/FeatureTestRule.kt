package eu.tutorials.quizapp.framework.testrule

import android.content.Intent
import androidx.test.rule.ActivityTestRule
import eu.tutorials.quizapp.MainActivity
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class FeatureTestRule : TestRule {

    private val activityRule = ActivityTestRule(MainActivity::class.java)

    override fun apply(base: Statement, description: Description): Statement =
        object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                setup()
                base.evaluate()
            }
        }

    private fun setup() {
        activityRule.launchActivity(Intent())
    }
}