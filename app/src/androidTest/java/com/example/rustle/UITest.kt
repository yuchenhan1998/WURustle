package com.example.rustle

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.rustle.activities.SellBookActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UITest {
    @get:Rule
    var booksellActivityTestRule: ActivityTestRule<SellBookActivity> = ActivityTestRule(SellBookActivity::class.java)


//    fun testAccountButton() {
////        onView(withId(R.id.setup)).perform(typeText("hello")).perform(closeSoftKeyboard())
////        onView(withId(R.id.punchline)).perform(typeText("goodbye")).perform(closeSoftKeyboard())
//        onView(withId(R.id.runButton)).perform(click())
////        onView(withId(R.id.setup)).check(matches(withText("")))
////        onView(withId(R.id.punchline)).check(matches(withText("")))
//
//    }

    @Test
    fun testSellBook() {
        onView(withId(R.id.bookname)).perform(typeText("Introduction to Psychology")).perform(closeSoftKeyboard())
        onView(withId(R.id.price)).perform(typeText("20")).perform(closeSoftKeyboard())
        onView(withId(R.id.message)).perform(typeText("Brand New")).perform(closeSoftKeyboard())
        onView(withId(R.id.bookname)).check(matches(withText("Introduction to Psychology")))
        onView(withId(R.id.price)).check(matches(withText("20")))
        onView(withId(R.id.message)).check(matches(withText("Brand New")))

    }

}