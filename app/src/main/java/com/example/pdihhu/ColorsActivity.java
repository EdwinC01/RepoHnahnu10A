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
        MediaPlayer mp = MediaPlayer.create(this, R.raw.ai_chan);

        imgBtnYellow.setOnClickListener(v -> mp.start());
    }
}