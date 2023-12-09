package com.example.pdihhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    private ImageButton atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView emailTextView = findViewById(R.id.emailTextView);

        atras = findViewById(R.id.left_icon);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void sendEmail(View view) {
        String emailAddress = "example@gmail.com";
        composeEmail(emailAddress);
    }

    private void composeEmail(String emailAddress) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + emailAddress));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Asunto del correo");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}