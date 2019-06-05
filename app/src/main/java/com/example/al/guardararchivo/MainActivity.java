package com.example.al.guardararchivo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.al.guardararchivo.R;

public class MainActivity extends Activity {

    private EditText ID;
    private EditText nombre;
    private EditText apellido;
    private EditText fNacimiento;
    private EditText telefono;
    private EditText correo;
    private EditText NSS;
    private EditText contactoEmergencia;
    private EditText enfermedadesCronicas;
    private EditText escolaridad;
    private EditText nacionalidad;
    private EditText direccion;
    private EditText area;
    private EditText puesto;
    private EditText estadoCivil;
    private EditText res;
    private Button cargar;
    static final int READ_BLOCK_SIZE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ID                      = (EditText) findViewById(R.id.txtID);
        nombre                  = (EditText) findViewById(R.id.txtNombre);
        apellido                = (EditText) findViewById(R.id.txtApellido);
        fNacimiento             = (EditText) findViewById(R.id.txtFNacimiento);
        telefono                = (EditText) findViewById(R.id.txtTelefono);
        correo                  = (EditText) findViewById(R.id.txtCorreo);
        NSS                     = (EditText) findViewById(R.id.txtNSS);
        contactoEmergencia      = (EditText) findViewById(R.id.txtContactoEmergencia);
        enfermedadesCronicas    = (EditText) findViewById(R.id.txtEnfermedadesCron);
        escolaridad             = (EditText) findViewById(R.id.txtEscolaridad);
        nacionalidad            = (EditText) findViewById(R.id.txtNacionalidad);
        direccion               = (EditText) findViewById(R.id.txtDireccion);
        area                    = (EditText) findViewById(R.id.txtArea);
        puesto                  = (EditText) findViewById(R.id.txtPuesto);
        estadoCivil             = (EditText) findViewById(R.id.txtEstadoCivil);
        res                     = (EditText) findViewById(R.id.txtRes);
        cargar                  = (Button)   findViewById(R.id.btnCargar);

        cargar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent carga = new Intent(MainActivity.this, Cargar.class);
                startActivity(carga);
            }
        });
    }

    public void onClickGuardar(View v){

        String strID                = ID.getText().toString();
        String strNombre            = nombre.getText().toString();
        String strApellido          = apellido.getText().toString();
        String strFNac              = fNacimiento.getText().toString();
        String strTelefono          = telefono.getText().toString();
        String strCorreo            = correo.getText().toString();
        String strNSS               = NSS.getText().toString();
        String strContactoEmerg     = contactoEmergencia.getText().toString();
        String strEnfermedadesCron  = enfermedadesCronicas.getText().toString();
        String strEscolaridad       = escolaridad.getText().toString();
        String strNacionalidad      = nacionalidad.getText().toString();
        String strDireccion         = direccion.getText().toString();
        String strArea              = area.getText().toString();
        String strPuesto            = puesto.getText().toString();
        String strEstadoCivil       = estadoCivil.getText().toString();

        try{
            FileOutputStream fos = openFileOutput("textFile.txt", MODE_APPEND);
            OutputStreamWriter osw = new OutputStreamWriter(fos);

            //fout.write(strID);
            //fout.close();

            // Escribimos el String en el archivo
            osw.write(strID +"\n");
            osw.write(strNombre +"\n");
            osw.write(strApellido +"\n");
            osw.write(strFNac +"\n");
            osw.write(strTelefono +"\n");
            osw.write(strCorreo +"\n");
            osw.write(strNSS +"\n");
            osw.write(strContactoEmerg +"\n");
            osw.write(strEnfermedadesCron +"\n");
            osw.write(strEscolaridad +"\n");
            osw.write(strNacionalidad +"\n");
            osw.write(strDireccion +"\n");
            osw.write(strArea +"\n");
            osw.write(strPuesto +"\n");
            osw.write(strEstadoCivil);
            osw.flush();
            osw.close();

            // Mostramos que se ha guardado
            Toast.makeText(getBaseContext(), "Guardado", Toast.LENGTH_SHORT).show();

            //textBox.setText("");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void onClickCargar(View v){
        try{
            FileInputStream fis = openFileInput("textFile.txt");
            InputStreamReader isr = new InputStreamReader(fis);

            char[] inputBuffer = new char[READ_BLOCK_SIZE];
            String s = "";

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