package com.example.giftapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class PurchasedGifts extends Activity {
    public static final String LOG_TAG = "GiftAppLog: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Gift fakeGift = new Gift("Ben", "New Computer", "8,000", "A very cool computer!",false);
        fakeGift.setPurchased(true);
        Storage.add_gift(fakeGift);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchased_gifts);
        displayPurchasedGifts();
    }

    protected void displayPurchasedGifts(){
        LinearLayout layout = (LinearLayout) findViewById(R.id.purchased_lin_layout);
        if(layout == null){
            Log.d(LOG_TAG, "FAILURE!!!!");
            return;
        }
        for(int i = 0; i < Storage.size(); i++){
            Gift gift = Storage.get_x_element(i);
            if(gift.getPurchased()){
                TextView newView = new TextView(getApplicationContext());
                String text = gift.getGiftName() + " was purchased for $" + gift.getGiftPrice() + " for " + gift.getForWhom() + ".";
                newView.setText((CharSequence) text);
                layout.addView(newView);
            }
        }
    }
}
