package com.company.chatterbook;

public class ChatterPost {
    private String text;

    public ChatterPost(String t) {
        text = t;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ChatterPost() {}
}
