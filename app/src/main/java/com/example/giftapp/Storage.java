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

    /**
     * Add a gift by each string element
     */
    public static void add_gift (String forWhom, String giftName, String giftPrice, String giftNotes, boolean purchased){
        collection.add(new Gift(forWhom,giftName,giftPrice,giftNotes,purchased));
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

    /**
     * saved the entire arraylist to the devices memory
     * @param sharedPreferences passes in getSharedPreferences("shared preferences", MODE_PRIVATE)
     */
    public void save_data(SharedPreferences sharedPreferences){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(collection);
        editor.putString("gifts", json);
        editor.apply();
    }

    /**
     * loads the entire arraylist to the devices memory
     * @param sharedPreferences passes in getSharedPreferences("shared preferences", MODE_PRIVATE)
     */
    public void load_data(SharedPreferences sharedPreferences){
        Gson gson = new Gson();
        String json = sharedPreferences.getString("gifts", null);
        Type type = new TypeToken<ArrayList<Gift>>() {}.getType();
        ArrayList <Gift> loading = new ArrayList<Gift>();
        collection = gson.fromJson(json, type);
        if (collection == null) {collection = new ArrayList<>();
        }
    }
}
