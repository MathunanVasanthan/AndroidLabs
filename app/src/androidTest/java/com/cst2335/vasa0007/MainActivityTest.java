package com.cst2335.vasa0007;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

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
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    /**
     * Tests if the password contains letters.
     */
    @Test
    public void testFindMissingLetters() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //find the view
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));

        //type in 12345
        appCompatEditText.perform(replaceText("12345"), closeSoftKeyboard());
        //click the button
        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        //find the text view
        ViewInteraction textView = onView(withId(R.id.textView));
        //check the text
        textView.check(matches(withText(R.string.tv2)));
    }

    /**
     * Tests if the password contains at least one uppercase letter.
     */
    @Test
    public void testFindMissingUpperCase(){
        //find the view
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));

        //type in password123#$*
        appCompatEditText.perform(replaceText("pswd123#$*"));
        //click the button
        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        //find the text view
        ViewInteraction textView = onView(withId(R.id.textView));
        //check the text
        textView.check(matches(withText(R.string.tv2)));
    }

    /**
     * Tests if the password contains at least one lowercase letter.
     */
    @Test
    public void testFindMissingLowerCase(){
        //find the view
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));

        //type in password123#$*
        appCompatEditText.perform(replaceText("PSWD123#$*"));
        //click the button
        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        //find the text view
        ViewInteraction textView = onView(withId(R.id.textView));
        //check the text
        textView.check(matches(withText(R.string.tv2)));
    }


    /**
     * Tests if the password contains at least one digit.
     */
    @Test
    public void testFindMissingDigit(){
        //find the view
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));

        //type in password123#$*
        appCompatEditText.perform(replaceText("Psswd#$*"));
        //click the button
        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        //find the text view
        ViewInteraction textView = onView(withId(R.id.textView));
        //check the text
        textView.check(matches(withText(R.string.tv2)));
    }

    /**
     * Tests if the password is too long in length.
     */
    @Test
    public void testLengthLong(){
        //find the view
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));

        //type in password123#$*
        appCompatEditText.perform(replaceText("Pswrd#$*12345678901247"));
        //click the button
        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        //find the text view
        ViewInteraction textView = onView(withId(R.id.textView));
        //check the text
        textView.check(matches(withText(R.string.tv2)));
    }

    /**
     * Tests if the password has all of these requirements.
     */
    @Test
    public void testEnoughComplexity(){
        //find the view
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));

        //type in password123#$*
        appCompatEditText.perform(replaceText("Psswd*$#98745"));
        //click the button
        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        //find the text view
        ViewInteraction textView = onView(withId(R.id.textView));
        //check the text
        textView.check(matches(withText(R.string.tv1)));
    }

}