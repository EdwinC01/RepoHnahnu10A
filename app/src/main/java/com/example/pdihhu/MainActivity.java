package com.example.pdihhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton Act1, Act2, Act3, Act4, game;
    String Title = "Pädi Hñähñu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Act1 = findViewById(R.id.btnAct1);
        Act1.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), ColorsActivity.class)));

        Act2 = findViewById(R.id.btnAct2);
        Act2.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), AlphabetActivity.class)));

        Act3 = findViewById(R.id.btnAct3);
        Act3.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), NumbersActivity.class)));

        Act4 = findViewById(R.id.btnAct4);
        Act4.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), SaludosActivity.class)));

        game = findViewById(R.id.gameScreen);
        game.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), GameScreenActivity.class)));
    }
}