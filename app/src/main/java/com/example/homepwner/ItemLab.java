package com.example.homepwner;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class ItemLab {
    private static ItemLab itemLab;
    private List<Item> items;
    private Random random = new Random();


    public static ItemLab get(Context context) {
        if (itemLab == null) {
            itemLab = new ItemLab(context);
        }
        return itemLab;

    }

    private String generateName() {

        String[] adjectives = {"happy", "sad", "excited", "angry", "bored",
                "friendly", "mean", "smart", "dumb", "rich",
                "poor", "busy", "lazy", "fat", "thin",
                "small", "big", "fast", "slow", "strong",
                "weak", "happy", "funny", "serious", "cute",
                "ugly", "pretty", "beautiful", "handsome", "scary"};
        String[] nouns = {"dog", "cat", "tree", "car", "house",
                "book", "computer", "phone", "music", "water",
                "sun", "moon", "stars", "sky", "mountain",
                "river", "ocean", "beach", "desk", "chair",
                "table", "food", "person", "animal", "flower",
                "tree", "building", "city", "country", "planet"};
        return adjectives[random.nextInt(30)] + " " + nouns[random.nextInt(30)];
    }

    private String generateSerial() {
        String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String result = "";
        for(int i = 0; i<8; i++) {
            int index = random.nextInt(62);
            result += CHAR_LIST.substring(index, index+1);
        }
        return result;
    }
    private ItemLab(Context context) {


        items = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Item item = new Item();
            item.setName(generateName());
            item.setValueInDollars(random.nextInt(1000)); // Every other one
            item.setId(generateSerial());
            items.add(item);

        }



    }

    public List<Item> getItems() {
        return items;
    }

    public Item getItem(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;

    }
}
