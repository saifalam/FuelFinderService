package com.fuelfinder.model.response;

/**
 * Created by saif on 24.11.17.
 */
public class OpeningTime {
    private String text;
    private String start;
    private String end;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
