package com.example.giftapp;
import android.content.SharedPreferences;
import android.content.Context;


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


    /**
     * This function will save the ArrayList onto the device for now
     * Later we might add a sync for database use
     * @return the number of saved gift objects
     */
    public int save_data(SharedPreferences sharedpreferences){

        // Working on it - Patrick

        int count = 0;
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("size",""+collection.size());
        for(;count<collection.size();++count) {
            editor.putString(count + ".1", collection.get(0).getForWhom());
            editor.putString(count + ".2", collection.get(0).getGiftName());
            editor.putString(count + ".3", collection.get(0).getGiftPrice());
            editor.putString(count + ".4", collection.get(0).getGiftNotes());
        }
        editor.commit();
        return count;
    }

    /**
     * This function loads the data from the device and stores it in the collection Arraylist
     * @return number of loaded gift objects
     */
    public int load_data(){

        // Working on it - Patrick
        
        return 0;
    }


}
