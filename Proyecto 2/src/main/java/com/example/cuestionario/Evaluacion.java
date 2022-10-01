package com.example.cuestionario;

public class Evaluacion {
    private Cuestionario cuestionario;
    private int cronometro;
    private int puntajeTotal;
    private String sobreNombre;

    public Evaluacion(Cuestionario cuestionario, String sobreNombre) {
        this.cuestionario = cuestionario;
        this.cronometro = 0;
        this.puntajeTotal = 0;
        this.sobreNombre = sobreNombre;
    }

    public Evaluacion(Cuestionario cuestionario, String sobreNombre,int puntajeTotal) {
        this.cuestionario = cuestionario;
        this.cronometro = 0;
        this.puntajeTotal = puntajeTotal;
        this.sobreNombre = sobreNombre;
    }

    public Cuestionario getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(Cuestionario cuestionario) {
        this.cuestionario = cuestionario;
    }

    public int getCronometro() {
        return cronometro;
    }

    public void setCronometro(int cronometro) {
        this.cronometro = cronometro;
    }

    public int getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(int puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }

    public String getSobreNombre() {
        return sobreNombre;
    }

    public void setSobreNombre(String sobreNombre) {
        this.sobreNombre = sobreNombre;
    }

    public String getNombreCuestionario() {
        return cuestionario.getNombre();
    }
}
