package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> implements AsyncTaskCompleteListener{
    public ApplicationTest() {
        super(Application.class);
        JokeFetcher jokeFetcher = new JokeFetcher(null,this);
        jokeFetcher.execute();
    }

    @Override
    public void taskComplete(String s) {
        assertNotNull(s);
        assertTrue(s.length()>0);
    }
}