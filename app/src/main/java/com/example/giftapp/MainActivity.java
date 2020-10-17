package com.example.giftapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = "GiftAppLog: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void view_add_gifts(View view){
        Log.d(LOG_TAG, "PurchasedGifts activity button Clicked!");
        Intent intent = new Intent(this, AddGifts.class);
        startActivity(intent);
    }

    public void view_purchased_gifts(View view) {
        Log.d(LOG_TAG, "AddGifts activity button Clicked!");
        Intent intent = new Intent(this, PurchasedGifts.class);
        startActivity(intent);
    }

    public void view_view_gifts(View view){
        Log.d(LOG_TAG, "ViewGifts activity button Clicked!");
        Intent intent = new Intent(this, ViewGifts.class);
        startActivity(intent);
    }
}