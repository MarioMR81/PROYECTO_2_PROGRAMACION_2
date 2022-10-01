package com.example.cuestionario;

import java.util.ArrayList;
import java.util.List;

public class Pregunta{
    private String pregunta;
    private int tiempoLimite;
    private int puntos;
    private List<String> respuestas;

    public Pregunta(String pregunta, int tiempoLimite, int puntos) {
        this.pregunta = pregunta;
        this.tiempoLimite = tiempoLimite;
        this.puntos = puntos;
        this.respuestas = new ArrayList<>();
    }

    public void addRespuesta(String respuesta)
    {
        respuestas.add(respuesta);
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getTiempoLimite() {
        return tiempoLimite;
    }

    public void setTiempoLimite(int tiempoLimite) {
        this.tiempoLimite = tiempoLimite;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public List<String> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<String> respuestas) {
        this.respuestas = respuestas;
    }
}
