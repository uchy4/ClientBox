package com.example.huff6.clientbox; /**
 * Created by joshu on 6/8/2016.
 */

import android.content.Context;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class TimerActivityTest {

    TimerActivity myObjectUnderTest = new TimerActivity();

    @Test
    public void onClickManualEntry() throws Exception {
        // ...when the int is returned from the object under test...
        int result = myObjectUnderTest.getValue();
        assertNotNull(result);
    }


    @Test
    public void onClickStartStop() throws Exception {

        // ...when the bool is returned from the object under test...
        Boolean result = myObjectUnderTest.getTimer();

        // ...then the result should be the expected one.
        assertTrue(result);
    }
}