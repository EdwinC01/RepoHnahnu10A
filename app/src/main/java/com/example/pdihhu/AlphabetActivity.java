package com.example.pdihhu;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

public class AlphabetActivity extends AppCompatActivity {
    String Title = "EL ALFABETO HÑÄHÑU | RA HMUNTS'A NSIHNI HÑÄHÑU";

    Button Aa, Aa_, Bb, Dd, Ee, Ee_, Ff, Gg, Hh, Ii, Jj, Kk, Ll, Mm, Nn, Nn_, Oo, Oo_, Pp, Rr, Ss, Tt, Uu, Uu_, Xx, Yy, Zz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        this.setTitle(Title);

        Aa = findViewById(R.id.Aa);
        MediaPlayer mpAa = MediaPlayer.create(this, R.raw.a);
        Aa.setOnClickListener(v -> mpAa.start());

        Aa_ = findViewById(R.id.Aa_);
        MediaPlayer mpAa_ = MediaPlayer.create(this, R.raw.a_puntitos);
        Aa_.setOnClickListener(v -> mpAa_.start());

        Bb = findViewById(R.id.Bb);
        MediaPlayer mpBb = MediaPlayer.create(this, R.raw.b);
        Bb.setOnClickListener(v -> mpBb.start());

        Dd = findViewById(R.id.Dd);
        MediaPlayer mpDd = MediaPlayer.create(this, R.raw.d);
        Dd.setOnClickListener(v -> mpDd.start());

        Ee = findViewById(R.id.Ee);
        MediaPlayer mpEe = MediaPlayer.create(this, R.raw.e);
        Ee.setOnClickListener(v -> mpEe.start());

        Ee_ = findViewById(R.id.Ee_);
        MediaPlayer mpEe_ = MediaPlayer.create(this, R.raw.e);
        Ee_.setOnClickListener(v -> mpEe_.start());

        Ff = findViewById(R.id.Ff);
        MediaPlayer mpFf = MediaPlayer.create(this, R.raw.f);
        Ff.setOnClickListener(v -> mpFf.start());

        Gg = findViewById(R.id.Gg);
        MediaPlayer mpGg = MediaPlayer.create(this, R.raw.g);
        Gg.setOnClickListener(v -> mpGg.start());

        Hh = findViewById(R.id.Hh);
        MediaPlayer mpHh = MediaPlayer.create(this, R.raw.h);
        Hh.setOnClickListener(v -> mpHh.start());

        Ii = findViewById(R.id.Ii);
        MediaPlayer mpIi = MediaPlayer.create(this, R.raw.i);
        Ii.setOnClickListener(v -> mpIi.start());

        Jj = findViewById(R.id.Jj);
        MediaPlayer mpJj = MediaPlayer.create(this, R.raw.j);
        Jj.setOnClickListener(v -> mpJj.start());

        Kk = findViewById(R.id.Kk);
        MediaPlayer mpKk = MediaPlayer.create(this, R.raw.k);
        Kk.setOnClickListener(v -> mpKk.start());

        Ll = findViewById(R.id.Ll);
        MediaPlayer mpLl = MediaPlayer.create(this, R.raw.l);
        Ll.setOnClickListener(v -> mpLl.start());

        Mm = findViewById(R.id.Mm);
        MediaPlayer mpMm = MediaPlayer.create(this, R.raw.m);
        Mm.setOnClickListener(v -> mpMm.start());

        Nn = findViewById(R.id.Nn);
        MediaPlayer mpNn = MediaPlayer.create(this, R.raw.n);
        Nn.setOnClickListener(v -> mpNn.start());

        Nn_ = findViewById(R.id.Nn_);
        MediaPlayer mpNn_ = MediaPlayer.create(this, R.raw.n_cejita);
        Nn_.setOnClickListener(v -> mpNn_.start());

        Oo = findViewById(R.id.Oo);
        MediaPlayer mpOo = MediaPlayer.create(this, R.raw.o);
        Oo.setOnClickListener(v -> mpOo.start());

        Oo_ = findViewById(R.id.O̲o̲);
        MediaPlayer mpOo_ = MediaPlayer.create(this, R.raw.o_);
        Oo_.setOnClickListener(v -> mpOo_.start());

        Pp = findViewById(R.id.Pp);
        MediaPlayer mpPp = MediaPlayer.create(this, R.raw.p);
        Pp.setOnClickListener(v -> mpPp.start());

        Rr = findViewById(R.id.Rr);
        MediaPlayer mpRr = MediaPlayer.create(this, R.raw.r);
        Rr.setOnClickListener(v -> mpRr.start());

        Ss = findViewById(R.id.Ss);
        MediaPlayer mpSs = MediaPlayer.create(this, R.raw.s);
        Ss.setOnClickListener(v -> mpSs.start());

        Tt = findViewById(R.id.Tt);
        MediaPlayer mpTt = MediaPlayer.create(this, R.raw.t);
        Tt.setOnClickListener(v -> mpTt.start());

        Uu = findViewById(R.id.Uu);
        MediaPlayer mpUu = MediaPlayer.create(this, R.raw.u);
        Uu.setOnClickListener(v -> mpUu.start());

        Uu_ = findViewById(R.id.U̲u̲);
        MediaPlayer mpUu_ = MediaPlayer.create(this, R.raw.u_);
        Uu_.setOnClickListener(v -> mpUu_.start());

        Xx = findViewById(R.id.Xx);
        MediaPlayer mpXx = MediaPlayer.create(this, R.raw.x);
        Xx.setOnClickListener(v -> mpXx.start());

        Yy = findViewById(R.id.Yy);
        MediaPlayer mpYy = MediaPlayer.create(this, R.raw.y);
        Yy.setOnClickListener(v -> mpYy.start());

        Zz = findViewById(R.id.Zz);
        MediaPlayer mpZz = MediaPlayer.create(this, R.raw.z);
        Zz.setOnClickListener(v -> mpZz.start());
    }
}