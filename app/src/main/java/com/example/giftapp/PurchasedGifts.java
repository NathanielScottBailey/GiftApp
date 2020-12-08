package com.example.giftapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class  PurchasedGifts extends Activity implements PurchasedGiftsAdapter.ClickedItem{

    public static final String LOG_TAG = "Here is the purchased: ";
    public AppDatabase db = AppDatabase.getInstance();
    List<Gift> giftList = db.giftDao().getPurchasedGifts(true);


    RecyclerView recyclerView;

    PurchasedGiftsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(LOG_TAG, giftList.toString());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchased_gifts);

        recyclerView = findViewById(R.id.purchaseRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        adapter = new PurchasedGiftsAdapter(this);

        getGifts();

    }

    @Override
    public void ClickedGift(Gift gift) {
        db.giftDao().deleteGift(gift);

    }

    public void getGifts() {
        // Give data to ViewAdapter
        adapter.setData(giftList);
        recyclerView.setAdapter(adapter);
    }


}

