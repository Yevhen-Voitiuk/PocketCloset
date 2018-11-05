package com.example.michael.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Outfit extends Entry {

    //Outfit-only data members
    private Clothing hat;
    private Clothing top; //shirt blouse etc
    private Clothing bottom;
    private Clothing shoes;
    private Clothing outerwear;
    private AccessoryNode head;

    static class AccessoryNode
    {
        Clothing item;
        AccessoryNode next;
        AccessoryNode(Clothing newItem)  { item = newItem;  next = null; } // Constructor
    }

    //private List<Clothing> accessories;

    //"Extended" methods from Entry
    public Outfit(String outfitName, int thumbnail) { super(outfitName, thumbnail); }
    public int getOutfitId() {
        return getEntryId();
    }
    public void setOutfitId(int outfitId) {
        setEntryId(outfitId);
    }
    public String getOutfitName() {
        return getEntryName();
    }
    public void setOutfitName(String outfitName) {
        setEntryName(outfitName);
    }

    //Outfit-only methods
    public Clothing getHat() {
        return hat;
    }
    public void setHat(Clothing hat) {
        this.hat = hat;
    }
    public Clothing getTop() {
        return top;
    }
    public void setTop(Clothing top) {
        this.top = top;
    }
    public Clothing getBottom() {
        return bottom;
    }
    public void setBottom(Clothing bottom) {
        this.bottom = bottom;
    }
    public Clothing getShoes() {
        return shoes;
    }
    public void setShoes(Clothing shoes) {
        this.shoes = shoes;
    }
    public Clothing getOuterwear() {
        return outerwear;
    }
    public void setOuterwear(Clothing outerwear) {
        this.outerwear = outerwear;
    }
    public Clothing addAccessory(Clothing newAccessory)
    {
        AccessoryNode tail;
        tail = head;
        //If linked list is empty, add the very first node
        if (tail == null) { tail = new AccessoryNode(newAccessory); return newAccessory; }

        //Otherwise, iterate to the end of the list and add a new node
        while (tail.next != null) { tail = tail.next; }
        tail.next = new AccessoryNode(newAccessory);
        return newAccessory;
    }
//    public List<Clothing> getAccessories() {
//        return accessories;
//    }
//
//    public Clothing addAccessory(Clothing newAccessory) {
//        accessories.add(newAccessory);
//        return newAccessory;
//    }
}
