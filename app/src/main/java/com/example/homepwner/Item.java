package com.example.homepwner;

import java.util.Date;
import java.util.UUID;

public class Item {
    private String name;
    private int valueInDollars;
    private String serialNumber;
    private Date dateCreated;

    public Item() {
        dateCreated = new Date();
    }

    public String getId() {
        return serialNumber;
    }

    public String getName() {
        return name;
    }
    public int getValue() {
        return valueInDollars;
    }

    public void setValueInDollars(int valueInDollars) {
        this.valueInDollars = valueInDollars;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.serialNumber = id;
    }


    public Date getDate() {
        return dateCreated;
    }
    public void setDate(Date date) {
        dateCreated = date;
    }

}
