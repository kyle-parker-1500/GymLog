package com.example.hw04_gymlog_v300;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AdminTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void adminTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.userNameLoginEditText),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("admin1"), closeSoftKeyboard());
        SystemClock.sleep(500);
        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.passwordLoginEditText),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("admin1"), closeSoftKeyboard());
        SystemClock.sleep(500);
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.loginButton), withText("Login!"),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                3),
                        isDisplayed()));
        appCompatButton.perform(click());
        SystemClock.sleep(500);
        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.exerciseInputEditText),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText(":)"), closeSoftKeyboard());

        SystemClock.sleep(500);
        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.weightInputEditText),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("100"), closeSoftKeyboard());

        SystemClock.sleep(500);
        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.repInputEditText),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                6),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("5"), closeSoftKeyboard());

        SystemClock.sleep(500);
        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.logButton), withText("Log!"),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                7),
                        isDisplayed()));
        appCompatButton2.perform(click());

        SystemClock.sleep(500);
        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.exerciseInputEditText), withText(":)"),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatEditText6.perform(replaceText(":("));

        SystemClock.sleep(500);
        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.exerciseInputEditText), withText(":("),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatEditText7.perform(closeSoftKeyboard());

        SystemClock.sleep(500);
        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.weightInputEditText), withText("100"),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatEditText8.perform(replaceText("1000"));

        SystemClock.sleep(500);
        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.weightInputEditText), withText("1000"),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatEditText9.perform(closeSoftKeyboard());

        SystemClock.sleep(500);
        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.repInputEditText), withText("5"),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                6),
                        isDisplayed()));
        appCompatEditText10.perform(replaceText("50"));

        SystemClock.sleep(500);
        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.repInputEditText), withText("50"),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                6),
                        isDisplayed()));
        appCompatEditText11.perform(closeSoftKeyboard());

        SystemClock.sleep(500);
        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.logButton), withText("Log!"),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                7),
                        isDisplayed()));
        appCompatButton3.perform(click());

        SystemClock.sleep(500);
        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.logoutMenuItem), withText("admin1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(com.google.android.material.R.id.action_bar),
                                        1),
                                0),
                        isDisplayed()));
        actionMenuItemView.perform(click());

        SystemClock.sleep(500);
        ViewInteraction appCompatButton4 = onView(
                allOf(withId(android.R.id.button1), withText("Logout"),
                        childAtPosition(
                                childAtPosition(
                                        withId(com.google.android.material.R.id.buttonPanel),
                                        0),
                                3)));
        appCompatButton4.perform(scrollTo(), click());

        SystemClock.sleep(500);
        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.userNameLoginEditText),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText12.perform(replaceText("admin1"), closeSoftKeyboard());

        SystemClock.sleep(500);
        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.passwordLoginEditText),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatEditText13.perform(replaceText("admin1"), closeSoftKeyboard());

        SystemClock.sleep(500);
        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.loginButton), withText("Login!"),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                3),
                        isDisplayed()));
        appCompatButton5.perform(click());

        SystemClock.sleep(500);
        ViewInteraction actionMenuItemView2 = onView(
                allOf(withId(R.id.logoutMenuItem), withText("admin1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(com.google.android.material.R.id.action_bar),
                                        1),
                                0),
                        isDisplayed()));
        actionMenuItemView2.perform(click());

        SystemClock.sleep(500);
        ViewInteraction appCompatButton6 = onView(
                allOf(withId(android.R.id.button1), withText("Logout"),
                        childAtPosition(
                                childAtPosition(
                                        withId(com.google.android.material.R.id.buttonPanel),
                                        0),
                                3)));
        appCompatButton6.perform(scrollTo(), click());
    }

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
