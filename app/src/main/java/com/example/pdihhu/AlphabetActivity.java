package com.example.pdihhu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AlphabetActivity extends AppCompatActivity implements View.OnClickListener {
    String Title = "EL ALFABETO HÑÄHÑU | RA HMUNTS'A NSIHNI HÑÄHÑU";

    // Variables
    private Button Aa, Aa_, Bb, Dd, Ee, Ee_, Ff, Gg, Hh, Ii, Jj, Kk, Ll, Mm, Nn, Nn_, Oo, Oo_, Pp, Rr, Ss, Tt, Uu, Uu_, Xx, Yy, Zz, Juego2;
    private MediaPlayer mediaPlayer;
    private ImageButton atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        atras = findViewById(R.id.left_icon);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Mostrar el título
        this.setTitle(Title);

        // Inicializar la variable para reproducir el sonido
        mediaPlayer = new MediaPlayer();

        // Inicializar el listener de cada botón seguido de referenciar el ID de cada botón
        Aa = findViewById(R.id.Aa);
        Aa.setOnClickListener(this::onClick);
        Aa_ = findViewById(R.id.Aa_);
        Aa_.setOnClickListener(this::onClick);
        Bb = findViewById(R.id.Bb);
        Bb.setOnClickListener(this::onClick);
        Dd = findViewById(R.id.Dd);
        Dd.setOnClickListener(this::onClick);
        Ee = findViewById(R.id.Ee);
        Ee.setOnClickListener(this::onClick);
        Ee_ = findViewById(R.id.Ee_);
        Ee_.setOnClickListener(this::onClick);
        Ff = findViewById(R.id.Ff);
        Ff.setOnClickListener(this::onClick);
        Gg = findViewById(R.id.Gg);
        Gg.setOnClickListener(this::onClick);
        Hh = findViewById(R.id.Hh);
        Hh.setOnClickListener(this::onClick);
        Ii = findViewById(R.id.Ii);
        Ii.setOnClickListener(this::onClick);
        Jj = findViewById(R.id.Jj);
        Jj.setOnClickListener(this::onClick);
        Kk = findViewById(R.id.Kk);
        Kk.setOnClickListener(this::onClick);
        Ll = findViewById(R.id.Ll);
        Ll.setOnClickListener(this::onClick);
        Mm = findViewById(R.id.Mm);
        Mm.setOnClickListener(this::onClick);
        Nn = findViewById(R.id.Nn);
        Nn.setOnClickListener(this::onClick);
        Nn_ = findViewById(R.id.Nn_);
        Nn_.setOnClickListener(this::onClick);
        Oo = findViewById(R.id.Oo);
        Oo.setOnClickListener(this::onClick);
        Oo_ = findViewById(R.id.O̲o̲);
        Oo_.setOnClickListener(this::onClick);
        Pp = findViewById(R.id.Pp);
        Pp.setOnClickListener(this::onClick);
        Rr = findViewById(R.id.Rr);
        Rr.setOnClickListener(this::onClick);
        Ss = findViewById(R.id.Ss);
        Ss.setOnClickListener(this::onClick);
        Tt = findViewById(R.id.Tt);
        Tt.setOnClickListener(this::onClick);
        Uu = findViewById(R.id.Uu);
        Uu.setOnClickListener(this::onClick);
        Uu_ = findViewById(R.id.U̲u̲);
        Uu_.setOnClickListener(this::onClick);
        Xx = findViewById(R.id.Xx);
        Xx.setOnClickListener(this::onClick);
        Yy = findViewById(R.id.Yy);
        Yy.setOnClickListener(this::onClick);
        Zz = findViewById(R.id.Zz);
        Zz.setOnClickListener(this::onClick);
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
            case R.id.Aa:
                // Reproducción de a
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.a);
                mediaPlayer.start();
                break;
            case R.id.Aa_:
                // Reproducción de ä
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.a_puntitos);
                mediaPlayer.start();
                break;
            case R.id.Bb:
                // Reproducción de b
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.b);
                mediaPlayer.start();
                break;
            case R.id.Dd:
                // Reproducción de d
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.d);
                mediaPlayer.start();
                break;
            case R.id.Ee:
                // Reproducción de e
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.e);
                mediaPlayer.start();
                break;
            case R.id.Ee_:
                // Reproducción de e
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.e_);
                mediaPlayer.start();
                break;
            case R.id.Ff:
                // Reproducción de f
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.f);
                mediaPlayer.start();
                break;
            case R.id.Gg:
                // Reproducción de g
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.g);
                mediaPlayer.start();
                break;
            case R.id.Hh:
                // Reproducción de h
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.h);
                mediaPlayer.start();
                break;
            case R.id.Ii:
                // Reproducción de i
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.i);
                mediaPlayer.start();
                break;
            case R.id.Jj:
                // Reproducción de j
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.j);
                mediaPlayer.start();
                break;
            case R.id.Kk:
                // Reproducción de k
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.k);
                mediaPlayer.start();
                break;
            case R.id.Ll:
                // Reproducción de l
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.l);
                mediaPlayer.start();
                break;
            case R.id.Mm:
                // Reproducción de m
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.m);
                mediaPlayer.start();
                break;
            case R.id.Nn:
                // Reproducción de n
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.n);
                mediaPlayer.start();
                break;
            case R.id.Nn_:
                // Reproducción de ñ
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.n_cejita);
                mediaPlayer.start();
                break;
            case R.id.Oo:
                // Reproducción de o
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.o);
                mediaPlayer.start();
                break;
            case R.id.O̲o̲:
                // Reproducción de o
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.o_);
                mediaPlayer.start();
                break;
            case R.id.Pp:
                // Reproducción de p
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.p);
                mediaPlayer.start();
                break;
            case R.id.Rr:
                // Reproducción de r
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.r);
                mediaPlayer.start();
                break;
            case R.id.Ss:
                // Reproducción de s
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.s);
                mediaPlayer.start();
                break;
            case R.id.Tt:
                // Reproducción de t
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.t);
                mediaPlayer.start();
                break;
            case R.id.Uu:
                // Reproducción de u
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.u);
                mediaPlayer.start();
                break;
            case R.id.U̲u̲:
                // Reproducción de u
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.u_);
                mediaPlayer.start();
                break;
            case R.id.Xx:
                // Reproducción de x
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.x);
                mediaPlayer.start();
                break;
            case R.id.Yy:
                // Reproducción de y
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.y);
                mediaPlayer.start();
                break;
            case R.id.Zz:
                // Reproducción de z
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.z);
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