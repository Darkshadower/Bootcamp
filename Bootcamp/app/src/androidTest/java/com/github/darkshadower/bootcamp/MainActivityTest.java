package com.github.darkshadower.bootcamp;

import android.content.Intent;
import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    //Enables automatic start before test (use @Test) and shutdown after test of activity
    @Rule
    public ActivityScenarioRule<MainActivity> testRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void properIntentWhenButtonIsPressed(){
        Intents.init();

        Espresso.onView(ViewMatchers.withId(R.id.mainName)).perform(ViewActions.typeText("Antoine"));
        closeSoftKeyboard();//Necessary otherwise, it cannot press button
        Espresso.onView(ViewMatchers.withId(R.id.mainGoButton)).perform(ViewActions.click());

        Intents.intended(Matchers.allOf(IntentMatchers.hasComponent(GreetingActivity.class.getName()), IntentMatchers.hasExtra(MainActivity.NAME_MESSAGE, "Antoine")));
        Intents.release();
    }
}
