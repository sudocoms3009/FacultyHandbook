package com.example.facultyhandbook;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import com.example.facultyhandbook.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void mainActivityTest() {
        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.dropdown),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.taskbar),
                                        0),
                                0)));
        appCompatImageView.perform(scrollTo(), click());
    }


/*
        ViewInteraction appCompatImageView2 = onView(
                allOf(withId(R.id.get_search),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.taskbar),
                                        0),
                                2)));
        appCompatImageView2.perform(scrollTo(), click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.edtSearch),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.taskbar),
                                        0),
                                1)));
        appCompatEditText.perform(scrollTo(), longClick());

        ViewInteraction cardView = onView(
                allOf(withId(R.id.science),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scroll),
                                        0),
                                0)));
        cardView.perform(scrollTo(), click());

        DataInteraction linearLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.science_listview),
                        childAtPosition(
                                withId(R.id.science),
                                0)))
                .atPosition(0);
        linearLayout.perform(click());

        pressBack();

        ViewInteraction cardView2 = onView(
                allOf(withId(R.id.commerce),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scroll),
                                        0),
                                1)));
        cardView2.perform(scrollTo(), click());

        DataInteraction linearLayout2 = onData(anything())
                .inAdapterView(allOf(withId(R.id.commerce_listview),
                        childAtPosition(
                                withId(R.id.commerce),
                                0)))
                .atPosition(3);
        linearLayout2.perform(click());

        pressBack();

        ViewInteraction cardView3 = onView(
                allOf(withId(R.id.engineering),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scroll),
                                        0),
                                2)));
        cardView3.perform(scrollTo(), click());

        DataInteraction linearLayout3 = onData(anything())
                .inAdapterView(allOf(withId(R.id.engineering_listview),
                        childAtPosition(
                                withId(R.id.engineering),
                                0)))
                .atPosition(1);
        linearLayout3.perform(click());

        pressBack();

        ViewInteraction cardView4 = onView(
                allOf(withId(R.id.health),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scroll),
                                        0),
                                3)));
        cardView4.perform(scrollTo(), click());

        DataInteraction linearLayout4 = onData(anything())
                .inAdapterView(allOf(withId(R.id.health_listview),
                        childAtPosition(
                                withId(R.id.health),
                                0)))
                .atPosition(2);
        linearLayout4.perform(click());

        pressBack();

        ViewInteraction cardView5 = onView(
                allOf(withId(R.id.humanity),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scroll),
                                        0),
                                4)));
        cardView5.perform(scrollTo(), click());

        DataInteraction linearLayout5 = onData(anything())
                .inAdapterView(allOf(withId(R.id.humanities_listview),
                        childAtPosition(
                                withId(R.id.humanities),
                                0)))
                .atPosition(0);
        linearLayout5.perform(click());

        pressBack();
    }*/

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
