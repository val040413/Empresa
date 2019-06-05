package com.example.al.guardararchivo;

import android.widget.EditText;

import java.io.Serializable;

public class Usuario implements Serializable {
    private EditText id;
    private EditText nombre;

    public Usuario(EditText id, EditText nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Usuario() {
    }

    public EditText getId() {
        return id;
    }

    public void setId(EditText id) {
        this.id = id;
    }

    public EditText getNombre() {
        return nombre;
    }

    public void setNombre(EditText nombre) {
        this.nombre = nombre;
    }
}
