package com.example.pdihhu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.content.DialogInterface;
import android.widget.TextView;

public class activityScrable extends AppCompatActivity {

    String Title = "Letras perdidas";
    private List<String> palabras = new ArrayList<>(); // Lista de palabras para el juego
    private String palabraActual;
    private EditText textViewResultado;
    private LinearLayout layoutLetras;
    private Button borrarUltimaLetra;
    private ImageButton atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrable);

        mostrarAlertaIniciarActividad();




        layoutLetras = findViewById(R.id.layoutLetras);
        textViewResultado = findViewById(R.id.textViewResultado);
        Button btnNuevaPalabra = findViewById(R.id.btnNuevaPalabra);
        Button btnVerificar = findViewById(R.id.btnVerificar);
        Button btnBorrarLetra = findViewById(R.id.btnBorrarLetra);
        ImageButton atras = findViewById(R.id.left_icon);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        textViewResultado.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ocultarTeclado(); // Llamar al método para ocultar el teclado
                return true;
            }
        });

        btnBorrarLetra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                borrarUltimaLetra();
            }
        });




        palabras.add("T'AXI");
        palabras.add("YOHO");
        palabras.add("GOHO");
        palabras.add("HÑU");
        palabras.add("N'A");
        palabras.add("R'ATO");
        palabras.add("YOTO");
        palabras.add("NONXI");
        palabras.add("MARTE");
        palabras.add("MIERKOLE");
        palabras.add("NSABDO");
        palabras.add("MBEHE");
        palabras.add("NJUEBE");
        palabras.add("NDOMINGO");
        palabras.add("K'ASTI");
        palabras.add("IXKI");
        palabras.add("NANXA");
        palabras.add("MBO'I");
        palabras.add("K'ANGI");
        palabras.add("THENI");
        palabras.add("T'AXI");
        palabras.add("B'OSPI");
        palabras.add("NOXA");
        palabras.add("B'OTHE");


        btnNuevaPalabra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seleccionarNuevaPalabra(); // Selecciona una nueva palabra para el juego
                textViewResultado.setText("");
            }
        });

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String palabraIngresada = textViewResultado.getText().toString().trim();

                if (palabraIngresada.equalsIgnoreCase(palabraActual)) {
                    // La palabra ingresada es correcta
                    mostrarAlerta("¡Felicidades!", "¡Has acertado!");
                    seleccionarNuevaPalabra();
                    textViewResultado.setText("");

                } else {
                    // La palabra ingresada es incorrecta
                    mostrarAlerta("Error", "La palabra ingresada no es correcta. Intenta de nuevo.");
                    textViewResultado.setText(""); // Borra el texto ingresado
                }
            }
        });


        seleccionarNuevaPalabra(); // Comienza el juego con una palabra nueva
    }
    // Método para ocultar el teclado
    private void ocultarTeclado() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(textViewResultado.getWindowToken(), 0);
    }

    private void seleccionarNuevaPalabra() {
        Random rand = new Random();
        palabraActual = palabras.get(rand.nextInt(palabras.size())); // Selecciona una palabra aleatoria

        // Muestra las letras desordenadas de la palabra como pista en el EditText

        // Muestra la palabra ordenada en el TextView textViewPalabraOrdenada
        TextView textViewPalabraOrdenada = findViewById(R.id.textViewPalabraOrdenada);
        textViewPalabraOrdenada.setText(palabraActual);

        // Obtener letras únicas de la palabra actual
        List<Character> letrasUnicas = new ArrayList<>();
        for (char c : palabraActual.toCharArray()) {
            if (!letrasUnicas.contains(c)) {
                letrasUnicas.add(c);
            }
        }

        // Limpiar los botones anteriores del GridLayout
        GridLayout gridLayoutLetras = findViewById(R.id.gridLayoutLetras);
        gridLayoutLetras.removeAllViews();

        // Agregar botones con letras únicas al GridLayout
        agregarBotonesLetras(letrasUnicas);
    }

    private String desordenarLetras(String palabra) {
        List<Character> letras = new ArrayList<>();
        for (char c : palabra.toCharArray()) {
            letras.add(c);
        }
        Collections.shuffle(letras);
        StringBuilder palabraDesordenada = new StringBuilder();
        for (char c : letras) {
            palabraDesordenada.append(c);
        }
        return palabraDesordenada.toString();
    }


    private void agregarBotonesLetras(List<Character> letrasUnicas) {
        // Limpiar los botones anteriores
        layoutLetras.removeAllViews();

        int numColumnas = 4; // Define el número de columnas basado en la cantidad de letras

        GridLayout gridLayoutLetras = findViewById(R.id.gridLayoutLetras);
        gridLayoutLetras.setColumnCount(numColumnas); // Establece el número de columnas dinámicamente

        // Mezclar las letras antes de agregar los botones
        Collections.shuffle(letrasUnicas);

        for (char letra : letrasUnicas) {
            Button button = new Button(this);
            button.setText(String.valueOf(letra));

            // Establecer el diseño visual del botón directamente
            button.setBackgroundColor(0xFF2196F3); // Cambiar el color del fondo del botón (por ejemplo, azul)
            button.setTextColor(0xFFFFFFFF); // Cambiar el color del texto del botón (por ejemplo, blanco)
            button.setTextSize(20); // Cambiar el tamaño del texto

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String currentText = textViewResultado.getText().toString();
                    textViewResultado.setText(currentText + letra);
                }
            });

            // Agregar el botón al GridLayout
            gridLayoutLetras.addView(button);
        }
    }


    // Función para mostrar la alerta
    private void mostrarAlerta(String titulo, String mensaje) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(titulo)
                .setMessage(mensaje)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Aquí puedes agregar lógica adicional después de hacer clic en OK
                    }
                })
                .show();
    }
    // Función para mostrar la alerta al iniciar la actividad
    private void mostrarAlertaIniciarActividad() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("¡Escribe y aprende!")
                .setMessage("¡Escribe las palabras que aparecen arriba y aprende a escribirlas correctamente!")
                .setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Aquí puedes agregar lógica adicional después de hacer clic en OK
                    }
                })

                .show();
    }

    private void borrarUltimaLetra() {
        String textoActual = textViewResultado.getText().toString();
        if (!textoActual.isEmpty()) {
            String nuevoTexto = textoActual.substring(0, textoActual.length() - 1);
            textViewResultado.setText(nuevoTexto);
        }
    }







}
