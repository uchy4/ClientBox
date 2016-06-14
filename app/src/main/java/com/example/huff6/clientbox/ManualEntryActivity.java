package com.example.huff6.clientbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class ManualEntryActivity extends AppCompatActivity {

    public static final String MESSAGE1 = "com.example.huff6.clientbox.MainActivity";
    public static final String MESSAGE2 = "com.example.huff6.clientbox.ClientLookupActivity";
    String start;
    String stop;
    String notes;
    Client client;
    boolean isValid;
    LocalConnection localConnection;


//////////////////////////////////
        private static Button date, time;
        private static TextView set_date, set_time;
        private static final int Date_id = 0;
        private static final int Time_id = 1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_manual_entry);

            Intent intent = getIntent();
            //either recieve from the main of recieve from the timer
            //we need to figure out how to switch between different intents
            String message = intent.getStringExtra(MainActivity.MESSAGE3);


            date = (Button) findViewById(R.id.selectdate);
            time = (Button) findViewById(R.id.selecttime);
            set_date = (TextView) findViewById(R.id.set_date);
            set_time = (TextView) findViewById(R.id.set_time);
            date.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {

// Show Date dialog
                    showDialog(Date_id);
                }
            });
            time.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {

// Show time dialog
                    showDialog(Time_id);
                }
            });

        }

    public void onClickSubmitManualEntry(View v) {
        //submit info to database

        //if added:
        Toast.makeText(ManualEntryActivity.this, "submitted successfully", Toast.LENGTH_SHORT).show();

        //go back to main page
        try {
            // move on to the main page
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(MESSAGE1, "");
            startActivity(intent);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void onClickManualEntryToClientLookup(View v){

        //go to client lookup
        try {
            // move on to the main page
            Intent intent = new Intent(this, ClientLookupActivity.class);
            intent.putExtra(MESSAGE2, "");
            startActivity(intent);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    protected Dialog onCreateDialog(int id) {

// Get the calander
        Calendar c = Calendar.getInstance();

// From calander get the year, month, day, hour, minute
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        switch (id) {
            case Date_id:

// Open the datepicker dialog
                return new DatePickerDialog(ManualEntryActivity.this, date_listener, year,
                        month, day);
            case Time_id:

// Open the timepicker dialog
                return new TimePickerDialog(ManualEntryActivity.this, time_listener, hour,
                        minute, false);

        }
        return null;
    }

    // Date picker dialog
    DatePickerDialog.OnDateSetListener date_listener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
// store the data in one string and set it to text
            String date1 = String.valueOf(month) + "/" + String.valueOf(day)
                    + "/" + String.valueOf(year);
            set_date.setText(date1);
        }
    };
    TimePickerDialog.OnTimeSetListener time_listener = new TimePickerDialog.OnTimeSetListener() {

        @Override
        public void onTimeSet(TimePicker view, int hour, int minute) {
// store the data in one string and set it to text
            String time1 = String.valueOf(hour) + ":" + String.valueOf(minute);
            set_time.setText(time1);
        }
    };

//////////////////////////////////



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
