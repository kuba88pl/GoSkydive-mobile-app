package com.goskydive.logbook;

import java.util.Map;

public class RecyclerViewLogBookModel {
    Long rcJumpNumber;
    String rcJumpDate;
    Long rcJumpHeight;
    String rcJumpStyle;
    Map<String, Object> nextJump;

    public RecyclerViewLogBookModel() {
    }

    public RecyclerViewLogBookModel(Long rcJumpNumber, String rcJumpDate, Long rcJumpHeight, String rcJumpStyle, Map<String, Object> nextJump) {
        this.rcJumpNumber = rcJumpNumber;
        this.rcJumpDate = rcJumpDate;
        this.rcJumpHeight = rcJumpHeight;
        this.rcJumpStyle = rcJumpStyle;
        this.nextJump = nextJump;
    }

    public Long getRcJumpNumber() {
        return rcJumpNumber;
    }

    public void setRcJumpNumber(Long rcJumpNumber) {
        this.rcJumpNumber = rcJumpNumber;
    }

    public String getRcJumpDate() {
        return rcJumpDate;
    }

    public void setRcJumpDate(String rcJumpDate) {
        this.rcJumpDate = rcJumpDate;
    }

    public Long getRcJumpHeight() {
        return rcJumpHeight;
    }

    public void setRcJumpHeight(Long rcJumpHeight) {
        this.rcJumpHeight = rcJumpHeight;
    }

    public String getRcJumpStyle() {
        return rcJumpStyle;
    }

    public void setRcJumpStyle(String rcJumpStyle) {
        this.rcJumpStyle = rcJumpStyle;
    }

    public Map<String, Object> getNextJump() {
        return nextJump;
    }

    public void setNextJump(Map<String, Object> nextJump) {
        this.nextJump = nextJump;
    }

    @Override
    public String toString() {
        return "RecyclerViewLogBookModel{" +
                "rcJumpNumber=" + rcJumpNumber +
                ", rcJumpDate='" + rcJumpDate + '\'' +
                ", rcJumpHeight=" + rcJumpHeight +
                ", rcJumpStyle='" + rcJumpStyle + '\'' +
                ", nextJump=" + nextJump +
                '}';
    }
}
