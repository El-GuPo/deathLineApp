package com.ru.elgupo.deathlineapp.model;

public class Deadline {
    private final String id;
    private String title;
    private String date;
    private String description;

    public Deadline(String title, String date, String description) {
        this.id = String.valueOf(System.currentTimeMillis()); // Простой ID
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public String getId() {
        return id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}