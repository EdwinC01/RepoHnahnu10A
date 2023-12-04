package com.example.pdihhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class GameScreenActivity extends AppCompatActivity {

    ImageButton imgGame1, imgGame2, imgGame3, imgGame4, atras;
    TextView txtGame1, txtGame2, txtGame3, txtGame4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        atras = findViewById(R.id.left_icon);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        imgGame1 = findViewById(R.id.imgGame1);
        imgGame2 = findViewById(R.id.imgGame2);
        imgGame3 = findViewById(R.id.imgGame3);
        imgGame4 = findViewById(R.id.imgGame4);

        imgGame1.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), RelationWordsActivity.class)));

        imgGame2.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), SoundWords.class)));

        imgGame3.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), memoramaActivity.class)));

        imgGame4.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), activityScrable.class)));

        txtGame1 = findViewById(R.id.txtGame1);
        txtGame1.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), RelationWordsActivity.class)));

        txtGame2 = findViewById(R.id.txtGame2);
        txtGame2.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), SoundWords.class)));

        txtGame3 = findViewById(R.id.txtGame3);
        txtGame3.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), memoramaActivity.class)));

        txtGame4 = findViewById(R.id.txtGame4);
        txtGame4.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), activityScrable.class)));
    }
}