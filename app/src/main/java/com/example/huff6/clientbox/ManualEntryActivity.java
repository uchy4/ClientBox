package com.example.huff6.clientbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;

public class ManualEntryActivity extends AppCompatActivity {

    Time start;
    Time stop;
    String notes;
    Client client;
    boolean isValid;
    LocalConnection localConnection;

    ManualEntryActivity() {
        start = new Time();
        stop = new Time();
        notes = "";
        isValid = false;
        localConnection = new LocalConnection();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_entry);
    }

    public void OnClickLookupClient() {

    }

    public void onClickSubmit() {

    }

    public void update(Time startInput, Time stopInput) {
        start = startInput;
        stop = stopInput;
    }

    public void validateTime() {

    }

    public boolean getIsValid() {
        return isValid;
    }
}
