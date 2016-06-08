package com.example.huff6.clientbox;


import android.text.format.Time;

/**
 * Created by joshu on 6/6/2016.
 */
public class Log {
    private Time startTime;
    private Time stopTime;
    private int duration;
    private String notes;

    Log () {
        Time temp = null;
        startTime = temp;
        stopTime = temp;
        duration = 0;
        notes = "";
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getStopTime() {
        return stopTime;
    }

    public int getDuration() {
        return duration;
    }

    public String getNotes() {
        return notes;
    }

    public void setStartTime(Time input) {
        startTime = input;
    }

    public void setStopTime(Time input) {
        stopTime = input;
    }

    public void setDuration(int input) {
        duration = input;
    }

    public void setNotes(String input) {
        notes = input;
    }

}
