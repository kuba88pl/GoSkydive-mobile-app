package com.goskydive.logbook;

import java.text.SimpleDateFormat;

public class DocumentSnapshot {
    private double recJumpNumber;
    private String recJumpDate;
    private double recJumpHeight;
    private String recJumpType;

    public DocumentSnapshot(long recJumpNumber, String recJumpDate, long recJumpHeight, String recJumpType) {
        this.recJumpNumber = recJumpNumber;
        this.recJumpDate = recJumpDate;
        this.recJumpHeight = recJumpHeight;
        this.recJumpType = recJumpType;
    }

    public double getRecJumpNumber() {
        return recJumpNumber;
    }

    public void setRecJumpNumber(long recJumpNumber) {
        this.recJumpNumber = recJumpNumber;
    }

    public String getRecJumpDate() {
        return recJumpDate;
    }

    public void setRecJumpDate(String recJumpDate) {
        this.recJumpDate = recJumpDate;
    }

    public double getRecJumpHeight() {
        return recJumpHeight;
    }

    public void setRecJumpHeight(long recJumpHeight) {
        this.recJumpHeight = recJumpHeight;
    }

    public String getRecJumpType() {
        return recJumpType;
    }

    public void setRecJumpType(String recJumpType) {
        this.recJumpType = recJumpType;
    }
}
