package com.example.huff6.clientbox;


import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by huff6 on 6/8/2016.
 */
public class ManualEntryActivityTest {

    public void onClickLookupClientTest() {
        // onClickLookupClient(ServerConnection) : void

    }

    public void onClickSubmitTest() {
        // onClickSubmit() : void
    }

    public void updateTest() {
        // update(Time, Time) : void

        String temp1 = "abc";
        String temp2 = "def";

        ManualEntryActivity MEA = new ManualEntryActivity();
        MEA.update(temp1, temp2);

        assertThat(temp1, is(temp1));
        assertThat(temp2 , is(temp2));
    }



    public void validateTimeTest() {
        // validateTime( start Time, stop Time) : void

        ManualEntryActivity MEA = new ManualEntryActivity();
        MEA.validateTime();

        assertTrue(MEA.getIsValid());
    }

}
