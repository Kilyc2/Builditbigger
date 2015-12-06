package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.MediumTest;

import java.util.concurrent.TimeUnit;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends AndroidTestCase {

    @MediumTest
    public void testJokeIsNonEmptyString() {
        try {
            JokesAsyncTask jokeTask = new JokesAsyncTask();
            jokeTask.execute();
            String joke = jokeTask.get(30, TimeUnit.SECONDS);
            assertFalse(joke.isEmpty());
        } catch (Exception e) {
            fail("Timed out!");
        }
    }
}