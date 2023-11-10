package com.example.pdihhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class ColorsActivity extends AppCompatActivity {
    String Title = "COLORES | Yä thuhu yä kuhu";

    ImageButton imgBtnYellow, imgBtnOrange, imgBtnBlue, imgBtnWhite, imgBtnGray, imgBtnBlack, imgBtnRed, imgBtnGreen;
    private Button Juego1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        this.setTitle(Title);

        imgBtnYellow = findViewById(R.id.amarillo);
        MediaPlayer mpYel = MediaPlayer.create(this, R.raw.amarillo);
        imgBtnYellow.setOnClickListener(v -> mpYel.start());

        imgBtnOrange = findViewById(R.id.naranja);
        MediaPlayer mpOra = MediaPlayer.create(this, R.raw.anaranjado);
        imgBtnOrange.setOnClickListener(v -> mpOra.start());

        imgBtnBlue = findViewById(R.id.azul);
        MediaPlayer mpBlu = MediaPlayer.create(this, R.raw.azul);
        imgBtnBlue.setOnClickListener(v -> mpBlu.start());

        imgBtnWhite = findViewById(R.id.blanco);
        MediaPlayer mpWhi = MediaPlayer.create(this, R.raw.frag_expl_water1);
        imgBtnWhite.setOnClickListener(v -> mpWhi.start());

        imgBtnGray = findViewById(R.id.gris);
        MediaPlayer mpGra = MediaPlayer.create(this, R.raw.gris);
        imgBtnGray.setOnClickListener(v -> mpGra.start());

        imgBtnBlack = findViewById(R.id.negro);
        MediaPlayer mpBla = MediaPlayer.create(this, R.raw.negro);
        imgBtnBlack.setOnClickListener(v -> mpBla.start());

        imgBtnRed = findViewById(R.id.rojo);
        MediaPlayer mpRed = MediaPlayer.create(this, R.raw.rojo);
        imgBtnRed.setOnClickListener(v -> mpRed.start());

        imgBtnGreen = findViewById(R.id.verde);
        MediaPlayer mpGre = MediaPlayer.create(this, R.raw.verde);
        imgBtnGreen.setOnClickListener(v -> mpGre.start());

        Juego1 = findViewById(R.id.btnJuego1);
        Juego1.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), RelationWordsActivity.class)));
    }
}