package com.example.huff6.clientbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ManualEntryActivity extends AppCompatActivity {

    String start;
    String stop;
    String notes;
    Client client;
    boolean isValid;
    LocalConnection localConnection;

    ManualEntryActivity() {
        start = new String();
        stop = new String();
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

    public void update(String startInput, String stopInput) {
        start = startInput;
        stop = stopInput;
    }

    public void validateTime() {

    }

    public boolean getIsValid() {
        return isValid;
    }
}
