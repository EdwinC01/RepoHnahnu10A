package com.example.pdihhu;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import android.content.DialogInterface;
import android.os.Handler;
import java.util.HashMap;
import java.util.Map;



public class SoundWords extends AppCompatActivity {
    private Map<String, String> soundColorMap;
    private Button buttonPlay;
    private Button buttonPlayAgain;

    private TextView textViewSound;
    private MediaPlayer mediaPlayer;
    private int[] soundResources = {R.raw.azul, R.raw.amarillo, R.raw.anaranjado, R.raw.rojo, R.raw.rosa, R.raw.cafe, R.raw.gris, R.raw.morado, R.raw.negro, R.raw.verde}; // Reemplaza con tus recursos de audio
    private Button[] optionButtons = new Button[3];
    private int correctButtonIndex;
    private String[] colores = {"Ixki", "K'ast'i", "Nanxa", "The̲ni", "Oxa", "B'othe", "B'ospi", "B'othi", "Mbo'i", "K'angi"}; // Nombres de los colores correspondientes a los sonidos

    private int maxAttempts = 3;
    private int currentAttempts = maxAttempts;
    private TextView textViewAttempts;
    private boolean soundPlayed = false;
    private Handler handler = new Handler();
    private int correctAnswersCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_words);

        // ... (inicializaciones de botones y vistas)

        soundColorMap = new HashMap<>();
        soundColorMap.put("azul", "#87CEEB"); // Colores según los sonidos
        soundColorMap.put("amarillo", "#FFFF00");
        soundColorMap.put("anaranjado", "#FFA500");
        soundColorMap.put("rojo", "#FF0000");
        soundColorMap.put("rosa", "#FFC0CB");
        soundColorMap.put("cafe", "#964B00");
        soundColorMap.put("gris", "#808080");
        soundColorMap.put("morado", "#800080");
        soundColorMap.put("negro", "#000000");
        soundColorMap.put("verde", "#008000");

        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPlayAgain = findViewById(R.id.buttonPlayAgain);
        textViewSound = findViewById(R.id.textViewSound);

        optionButtons[0] = findViewById(R.id.buttonOption1);
        optionButtons[1] = findViewById(R.id.buttonOption2);
        optionButtons[2] = findViewById(R.id.buttonOption3);

        textViewAttempts = findViewById(R.id.textViewAttempts);
        disableOptionButtons();
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playRandomSound();
            }
        });
        buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playCurrentSound();
            }
        });


        for (int i = 0; i < optionButtons.length; i++) {
            final int index = i;
            optionButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (currentAttempts > 0) {
                        checkAnswer(index);
                    } else {
                        showAlert();
                    }
                }
            });
        }
    }

    private void playCurrentSound() {
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(0); // Reinicia la reproducción desde el principio
            mediaPlayer.start();
        }
    }


    private void playRandomSound() {
        Random random = new Random();
        int soundIndex = random.nextInt(soundResources.length);

        if (mediaPlayer != null) {
            mediaPlayer.release();
        }

        mediaPlayer = MediaPlayer.create(this, soundResources[soundIndex]);
        mediaPlayer.start();
        String currentSound = colores[soundIndex];
        textViewSound.setText("Sonido Actual: " + colores[soundIndex]);
        setCorrectButton();
        changeBackgroundColor(currentSound.toLowerCase());

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                soundPlayed = true; // Marca que el sonido ha sido reproducido
                enableOptionButtons(); // Habilita los botones de opción después de reproducir el sonido
            }
        });
    }
    private void changeBackgroundColor(String colorName) {
        String backgroundColor = soundColorMap.get(colorName);

        if (backgroundColor != null) {
            getWindow().getDecorView().setBackgroundColor(Color.parseColor(backgroundColor));
        } else {
            // Si no se encuentra el color, se establece un color predeterminado
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#F2F2F2"));
        }
    }
    private void disableOptionButtons() {
        for (Button button : optionButtons) {
            button.setEnabled(false);
        }
    }

    private void enableOptionButtons() {
        for (Button button : optionButtons) {
            button.setEnabled(true);
        }
    }
    private void setCorrectButton() {
        Random random = new Random();
        correctButtonIndex = random.nextInt(optionButtons.length);
        int soundIndex = getIndexFromSoundName(textViewSound.getText().toString().replace("Sonido Actual: ", ""));

        optionButtons[correctButtonIndex].setText(colores[soundIndex]);

        for (int i = 0; i < optionButtons.length; i++) {
            if (i != correctButtonIndex) {
                String randomColor;
                do {
                    randomColor = colores[random.nextInt(colores.length)];
                } while (randomColor.equals(colores[soundIndex]) || isColorInButtons(randomColor, i));
                optionButtons[i].setText(randomColor);
            }
        }
    }

    private boolean isColorInButtons(String color, int endIndex) {
        for (int i = 0; i < endIndex; i++) {
            if (optionButtons[i].getText().toString().equals(color)) {
                return true;
            }
        }
        return false;
    }
    private void changeButtonColor(Button button, int color) {
        button.setBackgroundColor(color);
    }

    private void checkAnswer(int selectedButtonIndex) {
        String correctColor = textViewSound.getText().toString().replace("Sonido Actual: ", "");
        String selectedColor = optionButtons[selectedButtonIndex].getText().toString();
        Button selectedButton = optionButtons[selectedButtonIndex];
        if (!soundPlayed) {
            // El usuario intentó responder antes de reproducir el sonido
            Toast.makeText(this, "Por favor, reproduce el sonido primero", Toast.LENGTH_SHORT).show();
            return;
        }

        if (selectedColor.equals(correctColor)) {
            Toast.makeText(this, "¡Respuesta correcta!", Toast.LENGTH_SHORT).show();
            changeButtonColor(selectedButton, Color.GREEN); // Cambia el color a verde durante 1 segundo
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    changeButtonColor(selectedButton, Color.parseColor("#87CEEB")); // Restaura el color original
                    playRandomSound();
                }
            }, 1000);
            // Aquí puedes pasar a la siguiente ronda o realizar alguna acción adicional
            correctAnswersCount++;
            if (correctAnswersCount > 0 && correctAnswersCount % 10 == 0) {
                showCongratulationsAlert();
            }
        } else {
            Toast.makeText(this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
            changeButtonColor(selectedButton, Color.RED); // Cambia el color a rojo durante 1 segundo
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    changeButtonColor(selectedButton, Color.parseColor("#87CEEB")); // Restaura el color original
                    currentAttempts--;
                    updateAttemptsTextView();
                    if (currentAttempts == 0) {
                        showAlert();
                    }
                }
            }, 1000);
        }
    }
    private void showCongratulationsAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¡Felicidades por alcanzar 10 aciertos!")
                .setCancelable(false)
                .setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Acciones al hacer clic en "Continuar"
                    }
                })
                .setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void updateAttemptsTextView() {
        textViewAttempts.setText("Intentos restantes: " + currentAttempts);
    }

    private void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Ya no tienes intentos. ¿Salir o reintentar?")
                .setCancelable(false)
                .setPositiveButton("Reintentar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        resetAttempts();
                        playRandomSound();
                    }
                })
                .setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void resetAttempts() {
        currentAttempts = maxAttempts;
    }

    private int getIndexFromSoundName(String soundName) {
        for (int i = 0; i < colores.length; i++) {
            if (colores[i].equals(soundName)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
