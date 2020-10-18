package com.example.giftapp;

import java.util.ArrayList;

public class Storage {

    /**
     * Arraylist of gifts
     */
    private ArrayList <Gift> collection = new ArrayList<Gift>();

    /**
     * Add a gift by each string element
     */
    public void add_gift (String forWhom, String giftName, String giftPrice, String giftNotes){
        collection.add(new Gift(forWhom,giftName,giftPrice,giftNotes));
    }

    /**
     * @param toAdd an Gift object that gets added to the arraylist
     */
    public void add_gift (Gift toAdd){
        collection.add(toAdd);
    }

    /**
     * Removes and object from the collection
     * @param toRemove is the same element that gets removed
     * @return returns boolean if removed successfully
     */
    public boolean remove(Gift toRemove){
        return collection.remove(toRemove);
    }

    /**
     * Retruns the xth element starting with 0
     * @param x element to return
     * @return returns the x element
     */
    public Gift get_x_element(int x){
        return collection.get(x);
    }
    public int size(){
        return collection.size();
    }
}