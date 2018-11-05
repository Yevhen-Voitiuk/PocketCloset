package com.example.michael.myapplication;

import java.util.ArrayList;
import java.util.List;

public abstract class Entry
{
    //Data members shared by Clothing and Outfit
    protected int id;
    protected String name;
    protected int thumbnail;

    public Entry(String entryName, int thumbnail) {
        this.name = entryName;
        this.thumbnail = thumbnail;
    }

    //Methods that are shared by Clothing and Outfit
    public int getEntryId() {
        return id;
    }
    public void setEntryId(int id) {
        this.id = id;
    }

    public String getEntryName() {
        return name;
    }
    public void setEntryName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

}
