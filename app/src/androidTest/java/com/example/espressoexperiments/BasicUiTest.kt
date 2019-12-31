package com.example.espressoexperiments

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.CoreMatchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class BasicUiTest {

    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun assert_text_is_visible() {
        // Don't use assertions like withText inside onView.
        //Verify textview is visble
        onView(allOf(withId(R.id.textView), withText("hola mundo"))).check(matches(isDisplayed()))
    }

    @Test
    fun assert_textview_content_matches() {
        //Verify text content
        onView(withId(R.id.textView)).check(matches(withText("hola mundo")))
    }

    @Test
    fun assert_button_is_visible() {
        onView(withId(R.id.button)).check(matches(isDisplayed()))
    }

    @Test
    fun assert_button_text() {
        // Don't use assertions like withText inside onView.
        onView(allOf(withId(R.id.button), withText("ingresar"))).check(matches(isDisplayed()))
    }

    @Test
    fun assert_button_click() {
        onView(withId(R.id.button)).perform(click())
    }

    @Test
    fun assert_edit_text_is_visible() {
        onView(withId(R.id.editText)).check(matches(isDisplayed()))
    }

    @Test
    fun assert_edit_text_is_typeable() {
        onView(withId(R.id.editText)).perform(click(), replaceText("nuevo"))
        onView(withId(R.id.editText)).check(matches(withText("nuevo")))
    }

    @Test
    fun assert_that_edittext_changes_textview_during_search() {

        onView(withId(R.id.editText)).perform(click(), replaceText("n"))
        onView(withId(R.id.textView)).check(matches(withText("n")))

        onView(withId(R.id.editText)).perform(click(), typeText("u"))
        onView(withId(R.id.textView)).check(matches(withText("nu")))

        onView(withId(R.id.editText)).perform(click(), typeText("e"))
        onView(withId(R.id.textView)).check(matches(withText("nue")))

        onView(withId(R.id.editText)).perform(click(), typeText("v"))
        onView(withId(R.id.textView)).check(matches(withText("nuev")))

        onView(withId(R.id.editText)).perform(click(), typeText("o"))
        onView(withId(R.id.textView)).check(matches(withText("nuevo")))

    }

}