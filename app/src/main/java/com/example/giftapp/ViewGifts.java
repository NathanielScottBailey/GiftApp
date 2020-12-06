package com.example.giftapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;

public class ViewGifts extends Activity implements ViewAdapter.ClickedItem {
    static TextView view_gift_result;

    RecyclerView recyclerView;
    ViewAdapter viewAdapter;

    public AppDatabase db = AppDatabase.getInstance();
    List<Gift> giftList = db.giftDao().getAllGifts();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_gifts);

        // Set up recyclerview
        recyclerView = findViewById(R.id.recyclerview_view_gifts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        viewAdapter = new ViewAdapter(this);

        getGifts();

    }




    public void getGifts() {
        // Give data to ViewAdapter
        viewAdapter.setData(giftList);
        recyclerView.setAdapter(viewAdapter);



    }

    /**
     * Deletes all Gifts
     * @param view
     */
    public void deleteAll(View view) {
        Storage.clear();
        db.giftDao().nuke();
        viewAdapter.clear();
    }



    /**
     * Handles removing gift from Storage when the delete button is pressed.
     * @param gift
     */
    @Override
    public void ClickedGift(Gift gift) {
        db.giftDao().deleteGift(gift);

    }
}
