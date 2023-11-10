package com.example.pdihhu;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;


public class RelationWordsActivity extends AppCompatActivity {
    String Title = "Relacion de palabras";

    private List<Button> buttons = new ArrayList<>();
    private List<Button> selectedButtons = new ArrayList<>();
    private boolean[] isButtonClicked;

    private Handler handler = new Handler();

    private int pairCounter = 0; // Contador de pares seleccionados
    private int attempts = 3; // Límite de 3 intentos
    private TextView attemptsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relation_words);
        this.setTitle(Title);


        buttons.add((Button) findViewById(R.id.roj));
        buttons.add((Button) findViewById(R.id.Amarillo));
        buttons.add((Button) findViewById(R.id.azu));
        buttons.add((Button) findViewById(R.id.Naranja));
        buttons.add((Button) findViewById(R.id.Azul));
        buttons.add((Button) findViewById(R.id.ama));
        buttons.add((Button) findViewById(R.id.Blanco));
        buttons.add((Button) findViewById(R.id.ver));
        buttons.add((Button) findViewById(R.id.Gris));
        buttons.add((Button) findViewById(R.id.Negro));
        buttons.add((Button) findViewById(R.id.Rojo));
        buttons.add((Button) findViewById(R.id.gri));
        buttons.add((Button) findViewById(R.id.Verde));
        buttons.add((Button) findViewById(R.id.nar));
        buttons.add((Button) findViewById(R.id.bla));
        buttons.add((Button) findViewById(R.id.neg));







        String[] valores = {"Rojo", "Amarillo", "Azul", "Naranja", "Azul", "Amarillo", "Blanco",
                "Verde", "Gris", "Negro", "Rojo", "Gris", "Verde", "Naranja", "Blanco",
                "Negro"
        };

        // Inicializa el array de  clics
        isButtonClicked = new boolean[buttons.size()];

        for (int i = 0; i < buttons.size(); i++) {
            final Button button = buttons.get(i);
            final String valor = valores[i];

            button.setTag(valor);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (pairCounter < 2 && !isButtonClicked[buttons.indexOf(button)]) {
                        // Selecciona el botón y marcarlo en verde
                        selectedButtons.add(button);
                        button.setBackgroundColor(Color.GREEN);
                        isButtonClicked[buttons.indexOf(button)] = true;
                        pairCounter++;

                        if (pairCounter == 2) {
                            checkAndChangeColors();
                        }
                    }
                }
            });
        }

        // Vincula el TextView del contador de intentos
        attemptsTextView = findViewById(R.id.attemptsTextView);
    }
    private void animateShake(final Button button) {
        float delta = 10; // Ajusta la amplitud del movimiento
        long duration = 200; // Ajusta la duración del movimiento

        TranslateAnimation shake = new TranslateAnimation(0, delta, 0, 0);
        shake.setDuration(duration);
        shake.setInterpolator(new CycleInterpolator(5)); // Ajusta el número de ciclos de agitación

        button.startAnimation(shake);
    }

    private void checkAndChangeColors() {
        if (pairCounter == 2) {
            Button button1 = selectedButtons.get(0);
            Button button2 = selectedButtons.get(1);

            String valorBoton1 = button1.getTag().toString();
            String valorBoton2 = button2.getTag().toString();

            if (valorBoton1.equals(valorBoton2)) {
                // Si los botones son iguales, marcar en verde y ocultarlos después de 1 segundo
                button1.setBackgroundColor(Color.GREEN);
                button2.setBackgroundColor(Color.GREEN);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button1.setVisibility(View.GONE);
                        button2.setVisibility(View.GONE);
                        pairCounter = 0; // Reinicia contador de pares
                        selectedButtons.clear(); // Limpia lista de botones seleccionados
                    }
                }, 1000);
            } else {
                button2.setBackgroundColor(Color.RED);
                button1.setBackgroundColor(Color.RED);
                // Agrega animación de agitación a los botones no iguales
                animateShake(button1);
                animateShake(button2);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        resetColors();
                    }
                }, 1000);

                // Decrementa el número de intentos y verificar si se ha alcanzado el límite
                attempts--;

                if (attempts == 0) {

                    // Si se agotan los intentos, reiniciar todo
                    resetGame();
                }
            }

            // Actualiza el contador de intentos
            attemptsTextView.setText("Intentos restantes: " + attempts);
        }
    }

    private void resetColors() {
        int lighterGrayColor = Color.rgb(210, 210,210);

        for (Button button : buttons) {
            button.setBackgroundColor(lighterGrayColor);
        }

        for (int i = 0; i < isButtonClicked.length; i++) {
            isButtonClicked[i] = false;
        }

        pairCounter = 0; // Reinicia contador de pares
        selectedButtons.clear(); // Limpia lista de botones seleccionados
    }


    private void resetGame() {
        for (Button button : buttons) {
            button.setVisibility(View.VISIBLE);
        }
        resetColors();
        attempts = 3; // Restablece el número de intentos
        attemptsTextView.setText("Intentos restantes: " + attempts);
    }
}
