package com.example.pdihhu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AlphabetActivity extends AppCompatActivity {
    String Title = "RA HMUNTS'A NSIHNI HÑÄHÑU | EL ALFABETO HÑÄHÑU";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        this.setTitle(Title);
    }
}