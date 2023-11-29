package com.example.pdihhu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class NumbersActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, atras;
    private MediaPlayer mediaPlayer;

    String Title = "Números";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        atras = findViewById(R.id.left_icon);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        this.setTitle(Title);

        mediaPlayer = new MediaPlayer();


        // Inicializar el listener de cada botón seguido de referenciar el ID de cada botón
        uno = findViewById(R.id.uno);
        uno.setOnClickListener(this::onClick);
        dos = findViewById(R.id.dos);
        dos.setOnClickListener(this::onClick);
        tres = findViewById(R.id.tres);
        tres.setOnClickListener(this::onClick);
        cuatro = findViewById(R.id.cuatro);
        cuatro.setOnClickListener(this::onClick);
        cinco = findViewById(R.id.cinco);
        cinco.setOnClickListener(this::onClick);
        seis = findViewById(R.id.seis);
        seis.setOnClickListener(this::onClick);
        siete = findViewById(R.id.siete);
        siete.setOnClickListener(this::onClick);
        ocho = findViewById(R.id.ocho);
        ocho.setOnClickListener(this::onClick);
        nueve = findViewById(R.id.nueve);
        nueve.setOnClickListener(this::onClick);


    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        // Detén la reproducción anterior si está en curso
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.reset();
        }

        // Sentencia switch para reproducir la pronuciación según sea el caso
        switch (view.getId()) {
            case R.id.uno:
                // Reproducción de a
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.uno);
                mediaPlayer.start();
                break;
            case R.id.dos:
                // Reproducción de ä
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.dos);
                mediaPlayer.start();
                break;
            case R.id.tres:
                // Reproducción de b
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.tres);
                mediaPlayer.start();
                break;
            case R.id.cuatro:
                // Reproducción de d
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.cuatro);
                mediaPlayer.start();
                break;
            case R.id.cinco:
                // Reproducción de e
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.cinco);
                mediaPlayer.start();
                break;
            case R.id.seis:
                // Reproducción de f
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.seis);
                mediaPlayer.start();
                break;
            case R.id.siete:
                // Reproducción de g
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.siete);
                mediaPlayer.start();
                break;
            case R.id.ocho:
                // Reproducción de h
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ocho);
                mediaPlayer.start();
                break;
            case R.id.nueve:
                // Reproducción de h
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.nueve);
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