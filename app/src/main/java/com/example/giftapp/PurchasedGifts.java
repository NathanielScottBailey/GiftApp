package com.example.giftapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;

public class PurchasedGifts extends Activity {
    public static final String LOG_TAG = "GiftAppLog: ";
    public AppDatabase db = AppDatabase.getInstance();
    List<Gift> giftList = db.giftDao().getAllGifts();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // I have put in a method to add a test gift in place of the old fakeGift
        // This one gets add to the Room database and wil show up in the View Gifts Activity.
        addTestGift();

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
        for(int i = 0; i < giftList.size(); i++){

            Gift gift = giftList.get(i);

            // I checked and you are hitting this if statement with the test gift.
            if(gift.getPurchased()){
                TextView newView = new TextView(getApplicationContext());
                String text = gift.getGiftName() + " was purchased for $" + gift.getGiftPrice() + " for " + gift.getForWhom() + ".";
                newView.setText((CharSequence) text);
                layout.addView(newView);
            }
        }
    }

    public void addTestGift() {
        //Gift giftToAdd = new Gift("Ben", "New Computer", "8,000", "A very cool computer!", true);

        // Add giftToAdd to the database.
        //db.giftDao().insertAll(giftToAdd);
    }
}
