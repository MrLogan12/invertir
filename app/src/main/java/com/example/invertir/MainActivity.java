package com.example.invertir;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //atributos-variables
    private TextView txtResultado;
    private EditText etPalabra;
    private Button btnProcesar;
    private Button btnMensaje;
    private String palabra;
    String invertido;

    //metodos - funciones
    //metodos - funciones
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        /*
        al configurar un boton para decirle que este pendiente al evento clicj de ese boton en pantalla
        con el uso del metodo .setOnClickListener()
        Lo que ese mètodo esta esperando como parametro o argunmento es una funcion que serà
        la funciòn click que activara las funciones a realizar cuando se presione el boton.
        CuANDO SE PASA UNA FUNCION COMO PARAMENTRO ESTAS GENERALMENTE SON CONOCIDAD COMO FUNCINES ANONIMAS
        la idea es que esa funcion ejecute su proceimiento a partir del metodo que la recibe como parametro.
        */
        //this: ambito o contexto de la misma clase.  busca la respuesta en la clase
        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Este metodo onclick solo existe en el ambito del boton btnProcesar, lo que se haga a ca solo sirve para ese boton
                recibirInformacion();
                invertirPalabra();
            }
        });
        btnMensaje.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mostrarMensaje();
            }
        });
    }

    private void mostrarMensaje() {
        /*
        para mostarr mensajes en pantalla, ustedes pueden usar una ventana emergente temporal Toast que
        basicamnete sirve para mostrar informacion al usuario acerca de ciertas
        procesos que hayan pasado, comfirmaciones, mostar algunmensaje y oitro.
         */
        /*
        el toast tiene un metodo llamdo maketoast que es donde configuran lo que quieren mostrar al usuario,
        para que deban pasr estos
        - contexto (ambito) de la pantalla donde se va a dibujar ese mensaje
        - cadena de caracteres: el mensaje a mostrar
        -una contante de duracion del mensaje en pantalla para que dure
        finalmente debven decirle al toast que s muentre con esa configuracion y para ello usan el metodo o envento .show.
         */
        String mensajeMostrar = evaluarPaindromo();
        Toast.makeText(this, mensajeMostrar, Toast.LENGTH_LONG).show();
    }

    //Evaluar Palindromo
    private String evaluarPaindromo(){
        String mensaje = "No es palindromo";
        if (palabra.equals(this.invertido)) {
            mensaje = "Es palindromo";
        }
        return mensaje;
    }

    private void invertirPalabra() {
        //Una anera directa de inveritr una cadena
        //Netamente codigo java
        //palabra = new StringBuilder(palabra).reverse().toString();
        String invertido = "";
        //la idea es que traten la cadena como si fuera un array
        //donde cada letra esta en una posicion del array partiendo desde 0
        //para tal afecto los String tienen un metodo que les permite
        //devolver un caracter de una posicion como si fuera array
        //el metodo se llama .charAt(indice)
        for (int i = this.palabra.length() - 1; i >= 0; i--) {
            invertido += this.palabra.charAt(i);
        }
        if (invertido.equals(palabra)) {
            txtResultado.setText("Es un palindromo");
        } else {
            txtResultado.setText(invertido);
        }
    }

    private void recibirInformacion() {
        palabra = etPalabra.getText().toString();
    }

    private void inicializarVistas() {
        txtResultado = findViewById(R.id.txtResultado);
        etPalabra = findViewById(R.id.etPalabra);
        etPalabra = findViewById(R.id.etPalabra);
        btnProcesar = findViewById(R.id.btnProcesar);
    }
}