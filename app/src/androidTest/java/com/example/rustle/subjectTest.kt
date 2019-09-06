package com.example.rustle

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.rustle.activities.SellBookActivity
import com.example.rustle.model.Subjects
import junit.framework.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

class subjectTest {
    @get:Rule
    var mainActivityTestRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testSubjects() {
        val subjects = Subjects().getSubjects()
        assertTrue(subjects.size>0)
        for(i in 0 until subjects.size-1){
            assertTrue(subjects[i] < subjects[i+1])
        }
    }
}