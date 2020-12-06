package com.example.giftapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ViewGifts extends AppCompatActivity implements ViewAdapter.ClickedItem {
    static TextView view_gift_result;

    RecyclerView recyclerView;
    ViewAdapter viewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_gifts);
        //view_gift_result = findViewById(R.id.gift_view);

        //view_gift_result.append("\n");


//        if (Storage.size() == 0)
//            view_gift_result.append("There are no gifts.");

        //showGiftInfo();




        recyclerView = findViewById(R.id.recyclerview_view_gifts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        viewAdapter = new ViewAdapter(this);

        getGifts();

    }

    public void getGifts() {
        // Give data to ViewAdapter
        viewAdapter.setData(Storage.getGiftArrayList());
        recyclerView.setAdapter(viewAdapter);



    }


    /**
     * Handles removing gift when the delete button is pressed.
     * @param gift
     */
    @Override
    public void ClickedGift(Gift gift) {


        Storage.remove(gift);

        //Refreshes Activity
        Intent intent = new Intent(ViewGifts.this, ViewGifts.class);
        finish();
        startActivity(intent);
    }
}
