package com.example.pdihhu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;
import android.os.Bundle;
import android.widget.ImageButton;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class memoramaActivity extends AppCompatActivity {
    private ImageButton atras;
    // Declara un objeto MediaPlayer y un HashMap para mapear los recursos de imagen con los recursos de audio
    private MediaPlayer mediaPlayer;
    private HashMap<Integer, Integer> mapaAudios = new HashMap<>();
    private int intentosRestantes = 5;
    private TextView textViewIntentos;
    private ImageButton cartaMostrada = null; // Para mantener el seguimiento de la carta mostrada actualmente

    private static final int TIEMPO_MOSTRAR = 1000; // Tiempo en milisegundos para mostrar las cartas antes de ocultarlas
    private boolean estaMostrando = false;
    private Handler handler = new Handler();
    private List<ImageButton> listaBotones = new ArrayList<>();
    private int[] imagenesCartas = {R.drawable.cir_ama,
            R.drawable.cir_rojo,
            R.drawable.cir_rojo,
            R.drawable.cir_ama,
            R.drawable.cir_rosa,
            R.drawable.cir_nar,
            R.drawable.cir_neg,
            R.drawable.cir_azul,
            R.drawable.cir_azul,
            R.drawable.cir_bla,
            R.drawable.cir_cafe,
            R.drawable.cir_neg,
            R.drawable.cir_bla,
            R.drawable.cir_gris,
            R.drawable.cir_nar,
            R.drawable.cir_rosa,
            R.drawable.cir_cafe,
            R.drawable.cir_ver,
            R.drawable.cir_ver,
            R.drawable.cir_gris
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorama);

        atras = findViewById(R.id.left_icon);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        mostrarAlertaIniciarActividad();

        mapaAudios.put(R.drawable.cir_ama, R.raw.amarillo);
        mapaAudios.put(R.drawable.cir_rojo, R.raw.rojo);
        mapaAudios.put(R.drawable.cir_azul, R.raw.azul);
        mapaAudios.put(R.drawable.cir_cafe, R.raw.cafe);
        mapaAudios.put(R.drawable.cir_gris, R.raw.gris);
        mapaAudios.put(R.drawable.cir_nar, R.raw.anaranjado);
        mapaAudios.put(R.drawable.cir_neg, R.raw.negro);
        mapaAudios.put(R.drawable.cir_ver, R.raw.verde);
        mapaAudios.put(R.drawable.cir_rosa, R.raw.rosa);

        textViewIntentos = findViewById(R.id.textViewIntentos);
        ImageButton button1 = findViewById(R.id.button1);
        ImageButton button2 = findViewById(R.id.button2);
        ImageButton button3 = findViewById(R.id.button3);
        ImageButton button4 = findViewById(R.id.button4);
        ImageButton button5 = findViewById(R.id.button5);
        ImageButton button6 = findViewById(R.id.button6);
        ImageButton button7 = findViewById(R.id.button7);
        ImageButton button8 = findViewById(R.id.button8);
        ImageButton button9 = findViewById(R.id.button9);
        ImageButton button10 = findViewById(R.id.button10);
        ImageButton button11 = findViewById(R.id.button11);
        ImageButton button12 = findViewById(R.id.button12);
        ImageButton button13 = findViewById(R.id.button13);
        ImageButton button14 = findViewById(R.id.button14);
        ImageButton button15 = findViewById(R.id.button15);
        ImageButton button16 = findViewById(R.id.button16);
        ImageButton button17 = findViewById(R.id.button17);
        ImageButton button18 = findViewById(R.id.button18);
        ImageButton button19 = findViewById(R.id.button19);
        ImageButton button20 = findViewById(R.id.button20);

        listaBotones.add(button1);
        listaBotones.add(button2);
        listaBotones.add(button3);
        listaBotones.add(button4);
        listaBotones.add(button5);
        listaBotones.add(button6);
        listaBotones.add(button7);
        listaBotones.add(button8);
        listaBotones.add(button9);
        listaBotones.add(button10);
        listaBotones.add(button11);
        listaBotones.add(button12);
        listaBotones.add(button13);
        listaBotones.add(button14);
        listaBotones.add(button15);
        listaBotones.add(button16);
        listaBotones.add(button17);
        listaBotones.add(button18);
        listaBotones.add(button19);
        listaBotones.add(button20);

        for (final ImageButton button : listaBotones) {
            button.setImageResource(R.drawable.interrogacion);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Antes de procesar un intento, verifica si hay intentos restantes
                    if (intentosRestantes > 0 && !estaMostrando) {
                        manejarCartaSeleccionada(button);
                    } else {
                        // Si no hay intentos restantes, muestra un mensaje de alerta
                        mostrarMensajeIntentosAgotados();
                    }
                }
            });
        }


    }
    private void mostrarMensajeIntentosAgotados() {
        // Muestra una alerta indicando que los intentos se han agotado
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Se han agotado tus intentos")
                .setCancelable(false)
                .setPositiveButton("Reintentar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        reiniciarJuego(); // Lógica para reiniciar el juego
                    }
                })
                .setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Lógica para salir de la actividad o la aplicación
                        finish();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
    // Método para mostrar la alerta de felicitaciones
    private void mostrarMensajeFelicitaciones() {
        // Muestra una alerta felicitando al jugador
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¡Felicitaciones! Has completado el juego")
                .setCancelable(false)
                .setPositiveButton("Jugar de nuevo", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        reiniciarJuego(); // Lógica para reiniciar el juego
                    }
                })
                .setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Lógica para salir de la actividad o la aplicación
                        finish();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
    private boolean todasCartasAcertadas() {
        // Verifica si todas las cartas han sido acertadas
        for (int i = 0; i < imagenesCartas.length - 1; i++) {
            if (listaBotones.get(i).getVisibility() == View.VISIBLE) {
                return false;
            }
        }
        return true;
    }

    private void reiniciarJuego() {
        // Restablecer el número de intentos y el estado del juego
        intentosRestantes = 5;
        textViewIntentos.setText("Intentos restantes: " + intentosRestantes);

        // Ocultar todas las cartas y restablecer la lógica del juego
        for (ImageButton button : listaBotones) {
            button.setImageResource(R.drawable.interrogacion);
        }

        // Lógica adicional para reiniciar otras variables o estados del juego si es necesario

        // Vuelve a habilitar el clic en las cartas
        for (ImageButton button : listaBotones) {
            button.setEnabled(true);
        }
        estaMostrando = false;
        cartaMostrada = null;
    }

    private void manejarCartaSeleccionada(final ImageButton button) {
        if (button != null && intentosRestantes > 0 && !estaMostrando && (mediaPlayer == null || !mediaPlayer.isPlaying())) {
            int indice = listaBotones.indexOf(button);
            button.setImageResource(imagenesCartas[indice]);

            if (cartaMostrada == null) {
                cartaMostrada = button;
                realizarAnimacionGiro(cartaMostrada);
            } else {
                int indiceCartaMostrada = listaBotones.indexOf(cartaMostrada);

                // Verifica si la carta seleccionada es diferente a la que ya está mostrada
                if (indice != indiceCartaMostrada) {
                    if (imagenesCartas[indice] == imagenesCartas[indiceCartaMostrada]) {
                        cartaMostrada = null;
                        int recursoImagenCarta = imagenesCartas[indice];

                        // Reproduce el audio asociado con el recurso de imagen de la carta
                        if (mapaAudios.containsKey(recursoImagenCarta)) {
                            int recursoAudio = mapaAudios.get(recursoImagenCarta);
                            mediaPlayer = MediaPlayer.create(this, recursoAudio);
                            mediaPlayer.start();
                        }
                        if (todasCartasAcertadas()) {
                            mostrarMensajeFelicitaciones();
                        }
                    } else {
                        estaMostrando = true;
                        realizarAnimacionGiro(button);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ocultarCartas(cartaMostrada, button);
                                estaMostrando = false;
                                cartaMostrada = null;

                                if (imagenesCartas[indice] == imagenesCartas[indiceCartaMostrada]) {
                                    int recursoImagenCarta = imagenesCartas[indice];
                                    if (mapaAudios.containsKey(recursoImagenCarta)) {
                                        int recursoAudio = mapaAudios.get(recursoImagenCarta);
                                        mediaPlayer = MediaPlayer.create(memoramaActivity.this, recursoAudio);
                                        mediaPlayer.start();
                                    }
                                    if (todasCartasAcertadas()) {
                                        mostrarMensajeFelicitaciones();
                                    }
                                } else {
                                    // Verifica si las cartas no coinciden antes de reducir un intento
                                    if (!cartasComparadas(indice, indiceCartaMostrada)) {
                                        intentosRestantes--;
                                        textViewIntentos.setText("Intentos restantes: " + intentosRestantes);
                                        if (intentosRestantes <= 0) {
                                            mostrarMensajeIntentosAgotados();
                                        }
                                    }
                                }
                            }
                        }, TIEMPO_MOSTRAR);
                    }
                } else {
                    // Si se selecciona la misma carta dos veces, no se hace nada o puedes manejarlo según tu lógica
                }
            }
        }
    }

    private boolean cartasComparadas(int indice1, int indice2) {
        // Verifica si las cartas en los índices proporcionados ya han sido comparadas
        return imagenesCartas[indice1] == imagenesCartas[indice2];
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Liberar recursos del MediaPlayer al destruir la actividad
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }


    private void realizarAnimacionGiro(final ImageButton button) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(button, "rotationY", 0f, 180f);
        animator.setDuration(500); // Duración de la animación en milisegundos
        animator.start();
    }

    private void ocultarCartas(final ImageButton button1, final ImageButton button2) {
        // Realizar animación de giro para las dos cartas incorrectas
        realizarAnimacionGiro(button1);
        realizarAnimacionGiro(button2);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (ImageButton btn : listaBotones) {
                    if (btn == button1 || btn == button2) {
                        btn.setImageResource(R.drawable.interrogacion);
                    }
                }
                estaMostrando = false;
                cartaMostrada = null;
            }
        }, 500); // Tiempo de espera para la animación en milisegundos
    }

    // Función para mostrar la alerta al iniciar la actividad
    private void mostrarAlertaIniciarActividad() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("¡Memorama!")
                .setMessage("¡Tienes 5 intentos para encontrar las parejas de cada tarjeta!")
                .setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Aquí puedes agregar lógica adicional después de hacer clic en OK
                    }
                })

                .show();
    }
}