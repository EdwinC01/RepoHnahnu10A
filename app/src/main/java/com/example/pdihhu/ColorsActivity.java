package com.example.pdihhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toolbar;

public class ColorsActivity extends AppCompatActivity implements View.OnClickListener {
    String Title = "COLORES | Yä thuhu yä kuhu";

    ImageButton imgBtnYellow, imgBtnOrange, imgBtnBlue, imgBtnWhite, imgBtnGray, imgBtnBlack, imgBtnRed, imgBtnGreen, imgBtnPink, imgBtnCafe, atras;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        atras = findViewById(R.id.left_icon);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mediaPlayer = new MediaPlayer();

        imgBtnYellow = findViewById(R.id.amarillo);
        imgBtnYellow.setOnClickListener(this::onClick);

        imgBtnOrange = findViewById(R.id.naranja);
        imgBtnOrange.setOnClickListener(this::onClick);

        imgBtnBlue = findViewById(R.id.azul);
        imgBtnBlue.setOnClickListener(this::onClick);

        imgBtnBlack = findViewById(R.id.negro);
        imgBtnBlack.setOnClickListener(this::onClick);

        imgBtnRed = findViewById(R.id.rojo);
        imgBtnRed.setOnClickListener(this::onClick);

        imgBtnGreen = findViewById(R.id.verde);
        imgBtnGreen.setOnClickListener(this::onClick);

        imgBtnGray = findViewById(R.id.gris);
        imgBtnGray.setOnClickListener(this::onClick);

        imgBtnCafe = findViewById(R.id.cafe);
        imgBtnCafe.setOnClickListener(this::onClick);

        imgBtnPink = findViewById(R.id.rosa);
        imgBtnPink.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.reset();
        }
        switch (view.getId()) {
            case R.id.amarillo:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.amarillo);
                mediaPlayer.start();
                break;
            case R.id.azul:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.azul);
                mediaPlayer.start();
                break;
            case R.id.naranja:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.anaranjado);
                mediaPlayer.start();
                break;
            case R.id.negro:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.negro);
                mediaPlayer.start();
                break;
            case R.id.verde:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.verde);
                mediaPlayer.start();
                break;
            case R.id.rojo:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.rojo);
                mediaPlayer.start();
                break;
            case R.id.gris:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.gris);
                mediaPlayer.start();
                break;
            case R.id.cafe:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.cafe);
                mediaPlayer.start();
                break;
            case R.id.rosa:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.rosa);
                mediaPlayer.start();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        // Libera recursos cuando la actividad se destruye
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        super.onDestroy();
    }
}