package com.anna.Mid.entity;

public class Style {
    private String id;
    private String title;

    public Style(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public Style(String title){
        this.title = title;
    }

    public Style() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
