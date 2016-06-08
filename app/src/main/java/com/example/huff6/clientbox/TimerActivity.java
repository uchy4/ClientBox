 package com.example.huff6.clientbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TimerActivity extends AppCompatActivity {

    int time = 60;
    Boolean check = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
    }

    Boolean getTimer(){
        return check;
    }

    int getValue(){
        return time;
    }
}
