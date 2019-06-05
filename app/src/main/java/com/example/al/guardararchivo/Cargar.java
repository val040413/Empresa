package com.example.al.guardararchivo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cargar extends AppCompatActivity {

    Button ingresar;
    private EditText res;
    static final int READ_BLOCK_SIZE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargar);

        ingresar = (Button) findViewById(R.id.btnIngresar);
        res = (EditText) findViewById(R.id.txtRes);

        ingresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent carga = new Intent(Cargar.this, MainActivity.class);
                startActivity(carga);
            }


        });
    }
    public void onClickCargar(View v){
        String s = "";
        try{
            FileInputStream fis = openFileInput("textFile.txt");
            InputStreamReader isr = new InputStreamReader(fis);

            char[] inputBuffer = new char[READ_BLOCK_SIZE];

            int charRead;
            while((charRead = isr.read(inputBuffer)) > 0){

                // Convertimos los char a String
                String readString = String.copyValueOf(inputBuffer, 0, charRead);
                s += readString;

                inputBuffer = new char[READ_BLOCK_SIZE];

            }


            // Establecemos en el EditText el texto que hemos leido

            res.setText(s);
            // Mostramos un Toast con el proceso completado
            Toast.makeText(getBaseContext(), "Cargado", Toast.LENGTH_SHORT).show();

            isr.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
