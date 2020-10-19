package com.example.giftapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewGifts extends Activity {
    static TextView view_gift_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_gifts);
        view_gift_result = findViewById(R.id.gift_view);

        view_gift_result.append("\n");


        if (Storage.size() == 0)
            view_gift_result.append("There are no gifts.");

        showGiftInfo();


    }

    private void showGiftInfo(){
        for(int i = 0; i < Storage.size(); i++) {
            displayName(i);
            displayGift(i);
            displayPrice(i);
            displayNotes(i);
            view_gift_result.append("\n");
        }
    }

    private void displayName(int index){
        view_gift_result.append("For ");
        view_gift_result.append(Storage.get_x_element(index).getForWhom());
        view_gift_result.append(":\n");
    }

    private void displayGift(int index) {
        view_gift_result.append("Gift: ");
        view_gift_result.append(Storage.get_x_element(index).getGiftName());
        view_gift_result.append("\n");
    }

    private void displayPrice(int index) {
        view_gift_result.append("Price ");
        view_gift_result.append(Storage.get_x_element(index).getGiftPrice());
        view_gift_result.append("\n");
    }

    private void displayNotes(int index) {
        view_gift_result.append("Notes: ");
        view_gift_result.append(Storage.get_x_element(index).getGiftNotes());
        view_gift_result.append("\n");
    }


}
