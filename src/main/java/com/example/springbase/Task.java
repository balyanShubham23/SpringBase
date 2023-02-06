package com.example.springbase;

import java.util.Date;

public class Task {
    public Integer getId() {
        return id;
    }

    public Task(Integer id, String tile, String description, Date dueDate) {
        this.id = id;
        this.tile = tile;
        this.description = description;
        this.dueDate = dueDate;
    }

    Integer id;
    String tile;

    public void setId(Integer id) {
        this.id = id;
    }

    String description;

    Date dueDate;

    public void setTile(String tile) {
        this.tile = tile;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getTile() {
        return tile;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }
}
