package com.example.invertir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.invertir.R;

public class MainActivity extends AppCompatActivity{
    private TextView TBresult;
    private EditText TXword;
    private Button BTNexecute;
    private String word;

    private void initViews() {
        TBresult = findViewById(R.id.TBresult);
        TXword = findViewById(R.id.TXword);
        BTNexecute = findViewById(R.id.BTNexecute);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        /* Para el evento .setOnClickListener() podemos enviar un metodo o funcion (funcion Anonima)
        llamando a la interfaz .OnClickListener() que ejecute el procedimiento solo para el boton
        que llame al .setOnClickListener()
                Nombre_del_Boton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });
        En funcion LAMBDA
                Nombre_del_Boton.setOnClickListener(view -> {
                });
        */
        BTNexecute.setOnClickListener(view -> {
            recibeData();
            investWord();
        });
    }
    private void recibeData() {
        word = TXword.getText().toString();
    }
    private void investWord() {
        // Usando StringBuilder con Java sin usar codigo de Android
       // word = new StringBuilder(word).reverse().toString();//

        String invertido="adios";

        ///la idea es que traten la cadena string como si fuera un array donde cada letra
        // esta en una posicion del arrray partiendo de  0
        //decvolver un caracter de una posicion como si fuera un array
        //metodo charART indice
        for(int i = this.word.length() -1;  i >= 0 ; i--) {
            invertido +=  this.word.charAt(i);
        }

        TBresult.setText(invertido);
    }
}
//COMIT, PUSH cambia mis archivos,UPDATE actualizar y bajar todo de la nube