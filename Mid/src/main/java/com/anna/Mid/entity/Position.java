package com.anna.Mid.entity;

public class Position {
    private String id;
    private String title;

    public Position(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public Position(String title){
        this.title = title;
    }

    public Position() {
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
