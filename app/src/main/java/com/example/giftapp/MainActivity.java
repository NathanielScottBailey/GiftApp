package com.example.giftapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = "GiftAppLog: ";

    /**
     * Storage class
     * You can use that to store gifts and load gifts
     */
    public Storage gifts = new Storage();

    public static GiftDao giftDao;

    private TextView motd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        giftDao = AppDatabase.createInstance(this).giftDao();
        // giftDao.nuke();  // DEBUG: Delete all items in the database.
        giftDao.getAllGifts();

        gifts.load_data(getSharedPreferences("shared preferences", MODE_PRIVATE));

        //MOTD
        motd = findViewById(R.id.motd);
        getMOTD();
    }

    @Override
    protected void onPause() {
        super.onPause();
        gifts.save_data(getSharedPreferences("shared preferences", MODE_PRIVATE));
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

    public void getMOTD() {
        int motdID = 0;  // The motd is the first string from the call.
        Call<List<ServerMessage>> postList = RetrofitClient.getService().getMOTD();

        postList.enqueue(new Callback<List<ServerMessage>>() {
            @Override
            public void onResponse(Call<List<ServerMessage>> call, Response<List<ServerMessage>> response) {
                if(response.isSuccessful()){
                    List<ServerMessage> serverMessages = response.body();

                    String result = serverMessages.get(motdID).getText();
                    motd.setText(result);
                }
            }

            @Override
            public void onFailure(Call<List<ServerMessage>> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
            }
        });
    }

}