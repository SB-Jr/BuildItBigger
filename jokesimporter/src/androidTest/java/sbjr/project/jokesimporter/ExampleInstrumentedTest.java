package sbjr.project.jokesimporter;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("sbjr.project.jokesimporter.test", appContext.getPackageName());
    }

    @Test
    public void fetchTestNotNull() throws Exception{

        JokeFetcher jokeFetcher = new JokeFetcher();
        String s = jokeFetcher.execute().get();
        assertNotNull(s);
    }

    @Test
    public void fetchTestNotEmpty() throws Exception{

        JokeFetcher jokeFetcher = new JokeFetcher();
        String s = jokeFetcher.execute().get();
        assertNotEquals(s,"");
        Log.d("Test",s);
    }

}