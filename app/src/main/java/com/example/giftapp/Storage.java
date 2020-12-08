package com.example.giftapp;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Storage {

    /**
     * Arraylist of gifts
     */
    private static ArrayList <Gift> collection = new ArrayList<Gift>();

    public static ArrayList<Gift> getGiftArrayList() {
        return collection;
    }

    /**
     * Add a gift by each string element
     */
    public static void add_gift (String forWhom, String fromWhom, String address, String giftName, String giftPrice, String giftNotes, boolean purchased){
        collection.add(new Gift(forWhom, fromWhom, address, giftName, giftPrice, giftNotes, purchased));
    }

    /**
     * @param toAdd an Gift object that gets added to the arraylist
     */
    public static void add_gift (Gift toAdd){
        collection.add(toAdd);
    }

    /**
     * Removes and object from the collection
     * @param toRemove is the same element that gets removed
     * @return returns boolean if removed successfully
     */
    public static boolean remove(Gift toRemove){
        return collection.remove(toRemove);
    }

    /**
     * Retruns the xth element starting with 0
     * @param x element to return
     * @return returns the x element
     */
    public static Gift get_x_element(int x){
        return collection.get(x);
    }
    public static int size(){
        return collection.size();
    }

    public int save_data(SharedPreferences shared_preferences){

        return 0;
    }

    public int load_data(SharedPreferences shared_preferences){

        return 0;
    }

    public static void clear() {
        collection.clear();
    }
}
