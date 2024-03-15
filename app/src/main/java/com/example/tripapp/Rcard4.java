package com.example.tripapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Rcard4 extends AppCompatActivity {
    ImageView changeimage1, changeimage2, changeimage3, IMG_1;
    CardView pbackarrow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcard4);

        getSupportActionBar().hide();

        changeimage1 = findViewById(R.id.changeimage1);
        changeimage2 = findViewById(R.id.changeimage2);
        changeimage3 = findViewById(R.id.changeimage3);
        IMG_1 = findViewById(R.id.IMG_1);
        pbackarrow = findViewById(R.id.pbackarrow);

        changeimage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMG_1.setImageDrawable(getDrawable(R.drawable.varanasi));
            }
        });
        changeimage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMG_1.setImageDrawable(getDrawable(R.drawable.varanasi2));
            }
        });
        changeimage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMG_1.setImageDrawable(getDrawable(R.drawable.varansai3));
            }
        });
        pbackarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class ));
            }
        });
    }
}