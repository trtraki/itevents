package com.itevents.dao;

/**
 * Created by trtraki on 2014/06/21.
 */
public class ItEventsItem {
    private String title;
    private String date;
    private String prefecture;
    private String url;

    public ItEventsItem(String title, String date, String prefecture, String url) {
        this.title = title;
        this.date = date;
        this.prefecture = prefecture;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
