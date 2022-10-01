package com.example.cuestionario;

import java.util.ArrayList;
import java.util.List;

public class ListaCuestionarios {
    private List<Cuestionario> cuestionarios;

    public ListaCuestionarios() {
        this.cuestionarios = new ArrayList<>();
    }

    public void addCuestionario(Cuestionario c)
    {
        cuestionarios.add(c);
    }

    public List<Cuestionario> getCuestionarios() {
        return cuestionarios;
    }

    public void setCuestionarios(List<Cuestionario> cuestionarios) {
        this.cuestionarios = cuestionarios;
    }
}
