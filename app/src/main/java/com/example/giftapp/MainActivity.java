package com.example.giftapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import javax.microedition.khronos.egl.EGLDisplay;

import static android.provider.AlarmClock.EXTRA_MESSAGE;



public class MainActivity extends AppCompatActivity {
    public static final int TEXT_REQUEST = 1;
    public static final String EXTRA_MESSAGE =
            "com.example.giftapp.extra.MESSAGE";


    private EditText giftIdea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        giftIdea = findViewById(R.id.text_idea);
    }

    public void addIdea(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        String idea = giftIdea.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, idea);
        startActivityForResult(intent, TEXT_REQEUST);
    }
}