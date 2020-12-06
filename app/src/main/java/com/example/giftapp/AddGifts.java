package com.example.giftapp;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class AddGifts extends AppCompatActivity {
    public static final String LOG_TAG = "GiftAppLog: ";

    public AppDatabase db = AppDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_gifts);
    }

    public void add_gift(View view){
        EditText forWhom = findViewById(R.id.add_input1);
        EditText giftName = findViewById(R.id.add_input2);
        EditText giftPrice = findViewById(R.id.add_input3);
        EditText giftNotes = findViewById(R.id.add_input4);





        Gift giftToAdd = new Gift(forWhom.getText().toString(), giftName.getText().toString(),
                giftPrice.getText().toString(), giftNotes.getText().toString(),false);

        // Add giftToAdd to the database.
        db.giftDao().insertAll(giftToAdd);

        Log.d(LOG_TAG, "Gift created! INFO: " + giftToAdd.getForWhom() + ", " + giftToAdd.getGiftName() + ", "
                                                    + giftToAdd.getGiftPrice() + ", " + giftToAdd.getGiftNotes() + giftToAdd.getPurchased());

        // Leave Activity
        finish();
    }



}
