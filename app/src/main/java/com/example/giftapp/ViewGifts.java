package com.example.giftapp;

import android.app.Activity;
import android.os.Bundle;

public class ViewGifts extends Activity {
    public static final String LOG_TAG = "GiftAppLog: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_gifts);
    }
}
