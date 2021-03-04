package com.github.darkshadower.bootcamp;

import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;

public class GreetingActivityTest {
    //Enables automatic start before test (use @Test) and shutdown after test of activity
    @Rule
    public ActivityScenarioRule<MainActivity> testRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void messageIsDisplayedWhenIntentIsReceived(){
        String TEST_MESSAGE = "Alice";
        Intents.init();

        Intent intent = new Intent(ApplicationProvider.getApplicationContext(), GreetingActivity.class);
        intent.putExtra(MainActivity.NAME_MESSAGE, TEST_MESSAGE);
        try (ActivityScenario<GreetingActivity> scenario = ActivityScenario.launch(intent)) {
            Espresso.onView(ViewMatchers.withId(R.id.greetingMessage)).check(ViewAssertions.matches(ViewMatchers.withText(Matchers.containsString(TEST_MESSAGE))));
        }

        Intents.release();

    }
}
