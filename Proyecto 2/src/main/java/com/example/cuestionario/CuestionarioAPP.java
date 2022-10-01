package com.example.cuestionario;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CuestionarioAPP {
    private ListaCuestionarios listaCuestionarios;
    private List<Evaluacion> evaluaciones;

    public CuestionarioAPP() {
        listaCuestionarios = new ListaCuestionarios();
        evaluaciones = new ArrayList<>();
        initDefault();
    }

    public ListaCuestionarios getListaCuestionarios() {
        return listaCuestionarios;
    }

    public void setListaCuestionarios(ListaCuestionarios listaCuestionarios) {
        this.listaCuestionarios = listaCuestionarios;
    }

    private void initDefault()
    {
        listaCuestionarios.addCuestionario(new Cuestionario(123451,"Matematicas","Preguntas de matematicas"));//exhaustivo
        listaCuestionarios.addCuestionario(new Cuestionario(123452,"Programacion","Preguntas de programacion"));
        listaCuestionarios.addCuestionario(new Cuestionario(123453,"Historia","Preguntas de historia"));
        List<Cuestionario> lista = listaCuestionarios.getCuestionarios();
        evaluaciones.add(new Evaluacion(lista.get(0),"Usuario 1",10));
        evaluaciones.add(new Evaluacion(lista.get(1),"Usuario 2",20));
        evaluaciones.add(new Evaluacion(lista.get(1),"Usuario 3",30));
        evaluaciones.add(new Evaluacion(lista.get(2),"Usuario 4",40));
        evaluaciones.add(new Evaluacion(lista.get(2),"Usuario 5",50));
        evaluaciones.add(new Evaluacion(lista.get(2),"Usuario 6",60));
    }

    public void generarTop(String nombre)
    {
        List<Evaluacion> lista = new ArrayList<>();
        for (Evaluacion e: evaluaciones) {
            if(e.getNombreCuestionario().equalsIgnoreCase(nombre))
            {
                lista.add(e);
            }
        }
        Documento documento = new Documento();
        documento.createPDF(new File("Top.pdf"),lista);
    }

}
