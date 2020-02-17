package com.example.fixpack;

public class RecyclerItem {

    private String title;
    private String manualNumber;

    public RecyclerItem(String text1, String text2) {
        title           = text1;
        manualNumber    = text2;
    }

    public void changeText1(String text) {
        title = text;
    }

    public String getText1() {
        return title;
    }

    public String getText2() {
        return manualNumber;
    }
}
