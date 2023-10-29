package com.example.pdihhu;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageButton;

public class ColorsActivity extends AppCompatActivity {
    String Title = "COLORES | YA NJÄT'I";

    ImageButton imgBtnYellow, imgBtnOrange, imgBtnBlue, imgBtnWhite, imgBtnGray, imgBtnBlack, imgBtnRed, imgBtnGreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        this.setTitle(Title);

        imgBtnYellow = findViewById(R.id.amarillo);
        MediaPlayer mpYel = MediaPlayer.create(this, R.raw.frag_expl_water1);
        imgBtnYellow.setOnClickListener(v -> mpYel.start());

        imgBtnOrange = findViewById(R.id.naranja);
        MediaPlayer mpOra = MediaPlayer.create(this, R.raw.frag_expl_water1);
        imgBtnOrange.setOnClickListener(v -> mpOra.start());

        imgBtnBlue = findViewById(R.id.azul);
        MediaPlayer mpBlu = MediaPlayer.create(this, R.raw.frag_expl_water1);
        imgBtnBlue.setOnClickListener(v -> mpBlu.start());

        imgBtnWhite = findViewById(R.id.blanco);
        MediaPlayer mpWhi = MediaPlayer.create(this, R.raw.frag_expl_water1);
        imgBtnWhite.setOnClickListener(v -> mpWhi.start());

        imgBtnGray = findViewById(R.id.gris);
        MediaPlayer mpGra = MediaPlayer.create(this, R.raw.frag_expl_water1);
        imgBtnGray.setOnClickListener(v -> mpGra.start());

        imgBtnBlack = findViewById(R.id.negro);
        MediaPlayer mpBla = MediaPlayer.create(this, R.raw.frag_expl_water1);
        imgBtnBlack.setOnClickListener(v -> mpBla.start());

        imgBtnRed = findViewById(R.id.rojo);
        MediaPlayer mpRed = MediaPlayer.create(this, R.raw.frag_expl_water1);
        imgBtnRed.setOnClickListener(v -> mpRed.start());

        imgBtnGreen = findViewById(R.id.verde);
        MediaPlayer mpGre = MediaPlayer.create(this, R.raw.frag_expl_water1);
        imgBtnGreen.setOnClickListener(v -> mpGre.start());
    }
}