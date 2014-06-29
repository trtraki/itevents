package com.itevents.dao;

/**
 * Created by trtraki on 2014/06/21.
 */
public class ItEventsItem {
    private String title;
    private String date;
    private String prefecture;

    public ItEventsItem(String title, String date, String prefecture) {
        this.title = title;
        this.date = date;
        this.prefecture = prefecture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrefecture() {
        return prefecture;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }
}
