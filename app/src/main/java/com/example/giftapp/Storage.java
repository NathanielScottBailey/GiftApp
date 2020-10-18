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

    public int save_data(){
        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedpreferences.edit();


        for(int i=0;i<collection.size();++i) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(i + ".1", collection.get(0).getForWhom());
            editor.putString(i + ".2", collection.get(0).getGiftName());
            editor.putString(i + ".3", collection.get(0).getGiftPrice());
            editor.putString(i + ".4", collection.get(0).getGiftNotes());
            editor.commit();
        }


    }
    public int load_data(){

    }


}
