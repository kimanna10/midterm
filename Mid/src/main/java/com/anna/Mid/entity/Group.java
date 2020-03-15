package com.anna.Mid.entity;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String id;
    private String title;
    private int amountClient;
    private List<Style> styles = new ArrayList<>();

    public Group(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public Group(String title){
        this.title = title;
    }

    public Group() {
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

    public int getAmount() {
        return amountClient;
}

    public void setAmount(int amountClient) {
        this.amountClient = amountClient;
    }

    public List<Style> getStyle(int idGroup) {
        return styles;
    }

    public void addStyle(Style style) {
        styles.add(style);

    }



}
