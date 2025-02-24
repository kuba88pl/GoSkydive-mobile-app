package com.goskydive.logbook;

public class RecyclerViewLogBookModel {
    String rcJumpNumber;
    String rcJumpDate;
    String rcJumpHeight;
    String rcJumpStyle;

    public RecyclerViewLogBookModel(String rcJumpNumber, String rcJumpDate, String rcJumpHeight, String rcJumpStyle) {
        this.rcJumpNumber = rcJumpNumber;
        this.rcJumpDate = rcJumpDate;
        this.rcJumpHeight = rcJumpHeight;
        this.rcJumpStyle = rcJumpStyle;
    }

    public String getRcJumpNumber() {
        return rcJumpNumber;
    }

    public void setRcJumpNumber(String rcJumpNumber) {
        this.rcJumpNumber = rcJumpNumber;
    }

    public String getRcJumpDate() {
        return rcJumpDate;
    }

    public void setRcJumpDate(String rcJumpDate) {
        this.rcJumpDate = rcJumpDate;
    }

    public String getRcJumpHeight() {
        return rcJumpHeight;
    }

    public void setRcJumpHeight(String rcJumpHeight) {
        this.rcJumpHeight = rcJumpHeight;
    }

    public String getRcJumpStyle() {
        return rcJumpStyle;
    }

    public void setRcJumpStyle(String rcJumpStyle) {
        this.rcJumpStyle = rcJumpStyle;
    }
}
