package com.example.pdihhu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ColorsActivity extends AppCompatActivity {
    String Title = "COLORES | YA NJÄT'I";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        this.setTitle(Title);
    }
}