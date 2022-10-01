package com.example.cuestionario;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

public class Cuestionario {
    private int pin;
    private String nombre;
    private String descripcion;
    private boolean estado;
    private List<Pregunta> preguntas;

    private static int contador = 1111111;
    public Cuestionario(int pin, String nombre, String descripcion) {
        this.pin =  pin;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = true;
        preguntas = new ArrayList<>();
    }
    public Cuestionario(String nombre, String descripcion) {
        this.pin =  this.generarPin();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = true;
        preguntas = new ArrayList<>();
    }

    public void addPregunta(Pregunta pregunta)
    {
        preguntas.add(pregunta);
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Cuestionario.contador = contador;
    }

    private int generarPin()
    {
        return contador++;
    }
}
