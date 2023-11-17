package com.example.pdihhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toolbar;

public class ColorsActivity extends AppCompatActivity {
    String Title = "COLORES | Yä thuhu yä kuhu";

    ImageButton imgBtnYellow, imgBtnOrange, imgBtnBlue, imgBtnWhite, imgBtnGray, imgBtnBlack, imgBtnRed, imgBtnGreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        imgBtnYellow = findViewById(R.id.amarillo);
        MediaPlayer mpYel = MediaPlayer.create(this, R.raw.amarillo);
        imgBtnYellow.setOnClickListener(v -> mpYel.start());

        imgBtnOrange = findViewById(R.id.naranja);
        MediaPlayer mpOra = MediaPlayer.create(this, R.raw.anaranjado);
        imgBtnOrange.setOnClickListener(v -> mpOra.start());

        imgBtnBlue = findViewById(R.id.azul);
        MediaPlayer mpBlu = MediaPlayer.create(this, R.raw.azul);
        imgBtnBlue.setOnClickListener(v -> mpBlu.start());

        imgBtnBlack = findViewById(R.id.negro);
        MediaPlayer mpBla = MediaPlayer.create(this, R.raw.negro);
        imgBtnBlack.setOnClickListener(v -> mpBla.start());

        imgBtnRed = findViewById(R.id.rojo);
        MediaPlayer mpRed = MediaPlayer.create(this, R.raw.rojo);
        imgBtnRed.setOnClickListener(v -> mpRed.start());

        imgBtnGreen = findViewById(R.id.verde);
        MediaPlayer mpGre = MediaPlayer.create(this, R.raw.verde);
        imgBtnGreen.setOnClickListener(v -> mpGre.start());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}