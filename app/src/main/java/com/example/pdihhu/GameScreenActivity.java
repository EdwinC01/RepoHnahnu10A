package com.example.pdihhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class GameScreenActivity extends AppCompatActivity {

    ImageButton imgGame1, imgGame2, imgGame3, imgGame4 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        imgGame1 = findViewById(R.id.imgGame1);
        imgGame2 = findViewById(R.id.imgGame2);
        imgGame3 = findViewById(R.id.imgGame3);
        imgGame4 = findViewById(R.id.imgGame4);

        imgGame1.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), RelationWordsActivity.class)));

        imgGame2.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), SoundWords.class)));

        imgGame3.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), memoramaActivity.class)));

        imgGame4.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), activityScrable.class)));

    }
}