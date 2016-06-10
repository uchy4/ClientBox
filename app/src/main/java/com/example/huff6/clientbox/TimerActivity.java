 package com.example.huff6.clientbox;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

 public class TimerActivity extends AppCompatActivity {

    Chronometer chronometer;
     Button startStop;
    long time = 0;
    Boolean start = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        chronometer = (Chronometer) findViewById(R.id.chronometer);
        startStop = (Button) findViewById(R.id.btn_toggle_start_stop);

    }

    void onClickManualEntry(){
        time -= 30;//go to manual entry
    }
    long getTime(){
        return time;
    }

    public void onClickStartStop(View v){
        if (!start) {
            chronometer.setBase(SystemClock.elapsedRealtime()+time);
            chronometer.start();
            startStop.setText("Stop");
        }
        else {
            time = chronometer.getBase()-SystemClock.elapsedRealtime();
            chronometer.stop();
            startStop.setText("Start");
        }
        start = !start;
    }

     public void onClickReset(View v){
         chronometer.setBase(SystemClock.elapsedRealtime());
     }

}
