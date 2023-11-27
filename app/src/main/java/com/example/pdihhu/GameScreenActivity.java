package com.example.pdihhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class GameScreenActivity extends AppCompatActivity {

    ImageButton imgGame1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        imgGame1 = findViewById(R.id.imgGame1);
        imgGame1.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), RelationWordsActivity.class)));
    }
}