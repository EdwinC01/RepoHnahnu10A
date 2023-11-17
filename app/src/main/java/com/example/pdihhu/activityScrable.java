package com.example.pdihhu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class activityScrable extends AppCompatActivity {

    String Title = "Letras perdidas";
    EditText editTextLetter;
    Handler handler;
    boolean isMovingRight = true;
    int distanceToMove = 200; // Cambia esta distancia según tus necesidades

    TextView textViewH, textViewO; // Declarar otros TextViews aquí

    private float dX, dY;
    private boolean isDragging = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrable);
        this.setTitle(Title);

        // Inicializar TextViews
        textViewH = findViewById(R.id.textViewH);
        textViewO = findViewById(R.id.textViewO);
        // Inicializar otros TextViews aquí

        handler = new Handler();

        // Lógica para cambiar las posiciones de derecha a izquierda cada 2 segundos
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isDragging) {
                    int translationX = isMovingRight ? distanceToMove : -distanceToMove;

                    // Mover los TextViews
                    moveTextView(textViewH, translationX);
                    moveTextView(textViewO, translationX);
                    // Mover otros TextViews aquí

                    isMovingRight = !isMovingRight;
                }
                handler.postDelayed(this, 2000); // Cambia el intervalo de tiempo aquí
            }
        }, 2000); // Cambia el intervalo de tiempo aquí también

        // Asignar el comportamiento de arrastre a cada TextView
        setDraggable(textViewH);
        setDraggable(textViewO);
        // Configurar para otros TextViews aquí
    }

    // Método para mover un TextView
    private void moveTextView(TextView textView, int translationX) {
        textView.animate().translationXBy(translationX).setDuration(1000);
    }

    private void setDraggable(final TextView textView) {
        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        isDragging = true;
                        dX = view.getX() - event.getRawX();
                        dY = view.getY() - event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        view.animate()
                                .x(event.getRawX() + dX)
                                .y(event.getRawY() + dY)
                                .setDuration(0)
                                .start();
                        break;
                    case MotionEvent.ACTION_UP:
                        isDragging = false;
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });
    }
}
