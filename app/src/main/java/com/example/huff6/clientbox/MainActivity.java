package com.example.huff6.clientbox;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.provider.CallLog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //We need a thread singleton object here

    public static final String MESSAGE = "com.example.huff6.clientbox.AddClientActivity";
    public static final String MESSAGE2 = "com.example.huff6.clientbox.TimerActivity";
    public static final String MESSAGE3 = "com.example.huff6.clientbox.ManualEntryActivity";
    public static final String MESSAGE4 = "com.example.huff6.clientbox.ClientLookupActivity";

    TextView call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //eye h8 meyecall <3
        //View temp = findViewById(R.id.awesome);


        Intent intent = getIntent();
        String message = intent.getStringExtra(LoginActivity.EXTRA_MESSAGE);

        call = (TextView) findViewById(R.id.call);
        updateCallInfo();
    }

    public void goToAddClient(View v){
        //go to add client page
        try {
            // move on to the main page
            Intent intent = new Intent(this, AddClientActivity.class);
            intent.putExtra(MESSAGE, "");
            startActivity(intent);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void goToTimer(View v){
        //go to add client page
        try {
            // move on to the main page
            Intent intent = new Intent(this, TimerActivity.class);
            intent.putExtra(MESSAGE2, "");
            startActivity(intent);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void goToManualEntry(View v){
        //go to add client page
        try {
            // move on to the main page
            Intent intent = new Intent(this, ManualEntryActivity.class);
            intent.putExtra(MESSAGE3, "");
            startActivity(intent);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void goToClientLookup(View v){
        //go to add client page
        try {
            // move on to the main page
            Intent intent = new Intent(this, ClientLookupActivity.class);
            intent.putExtra(MESSAGE4, "");
            startActivity(intent);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    void updateCallInfo(){
        try {
            Context context;
            StringBuffer sb = new StringBuffer();
            Cursor managedCursor =  managedQuery(CallLog.Calls.CONTENT_URI, null, null, null, null);
            int number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);
            int type = managedCursor.getColumnIndex(CallLog.Calls.TYPE);
            int date = managedCursor.getColumnIndex(CallLog.Calls.DATE);
            int duration = managedCursor.getColumnIndex(CallLog.Calls.DURATION);
            sb.append("Call Details :");
            while (managedCursor.moveToNext()) {
                String phNumber = managedCursor.getString(number);
                String callType = managedCursor.getString(type);
                String callDate = managedCursor.getString(date);
                Date callDayTime = new Date(Long.valueOf(callDate));
                String callDuration = managedCursor.getString(duration);
                String dir = null;
                int dircode = Integer.parseInt(callType);
                switch (dircode) {
                    case CallLog.Calls.OUTGOING_TYPE:
                        dir = "OUTGOING";
                        break;

                    case CallLog.Calls.INCOMING_TYPE:
                        dir = "INCOMING";
                        break;

                    case CallLog.Calls.MISSED_TYPE:
                        dir = "MISSED";
                        break;
                }
                sb.append("\nPhone Number:--- " + phNumber + " \nCall Type:--- " + dir + " \nCall Date:--- " + callDayTime + " \nCall duration in sec :--- " + callDuration);
                sb.append("\n----------------------------------");
            }
            //sb is the call information
            managedCursor.close();
            call.setText("updated");
        } catch (Exception e){}
    }
}
