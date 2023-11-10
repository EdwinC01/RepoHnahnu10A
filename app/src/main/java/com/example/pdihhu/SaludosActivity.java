package com.example.pdihhu;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SaludosActivity extends AppCompatActivity implements View.OnClickListener {

    String Title = "DÍAS DE LA SEMANA | Yä thuhu yä yoto mapá";

    private Button lun, mar, mie, jue, vie, sab, dom;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludos);

        setTitle(Title);

        mediaPlayer = new MediaPlayer();

        lun = findViewById(R.id.lunes);
        lun.setOnClickListener(this::onClick);
        mar = findViewById(R.id.martes);
        mar.setOnClickListener(this::onClick);
        mie = findViewById(R.id.miercoles);
        mie.setOnClickListener(this::onClick);
        jue = findViewById(R.id.jueves);
        jue.setOnClickListener(this::onClick);
        vie = findViewById(R.id.viernes);
        vie.setOnClickListener(this::onClick);
        sab = findViewById(R.id.sabado);
        sab.setOnClickListener(this::onClick);
        dom = findViewById(R.id.domingo);
        dom.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.reset();
        }

        switch (v.getId()) {
            case R.id.lunes:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.lunes);
                mediaPlayer.start();
                break;
            case R.id.martes:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.martes);
                mediaPlayer.start();
                break;
            case R.id.miercoles:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.miercoles);
                mediaPlayer.start();
                break;
            case R.id.jueves:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.jueves);
                mediaPlayer.start();
                break;
            case R.id.viernes:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.viernes);
                mediaPlayer.start();
                break;
            case R.id.sabado:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.sabado);
                mediaPlayer.start();
                break;
            case R.id.domingo:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.domingo);
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