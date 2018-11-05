package com.example.michael.myapplication;

public class Closet {

    private String closetName;
    private String description;
    private int thumbnail;
    private char type;

    public Closet(String closetName, String description, int thumbnail, char type) {
        this.closetName = closetName;
        this.description = description;
        this.thumbnail = thumbnail;
        this.type = type;
    }

    public String getClosetName() {
        return closetName;
    }

    public String getDescription() {
        return description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public char getType() { return type; }

    public void setClosetName(String closetName) {
        this.closetName = closetName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setType(char type) {
        this.type = type;
    }

}
