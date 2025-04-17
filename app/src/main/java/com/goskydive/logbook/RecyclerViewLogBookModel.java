package com.goskydive.logbook;

import java.util.Map;

public class RecyclerViewLogBookModel {
    Map<String, Object> nextJump;

    public RecyclerViewLogBookModel() {
    }

    public RecyclerViewLogBookModel(Map<String, Object> nextJump) {
        this.nextJump = nextJump;
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
                "nextJump=" + nextJump +
                '}';
    }
}
