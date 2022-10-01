package com.example.cuestionario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class NuevaPreguntaController implements Initializable {
    @FXML
    private ComboBox tiempo;

    @FXML
    private TextField fieldPregunta;

    @FXML
    private TextField fieldPuntos;

    @FXML
    private TextField fieldRespuesta1;

    @FXML
    private TextField fieldRespuesta2;

    @FXML
    private TextField fieldRespuesta3;

    @FXML
    private TextField fieldRespuesta4;

    private CuestionarioAPP cuestionarioAPP;

    private Cuestionario cuestionario ;

    private Pregunta pregunta;

    public void setCuestionario(Cuestionario cuestionario)
    {
        this.cuestionario = cuestionario;
    }
    public  void setCuestionarioAPP(CuestionarioAPP cuestionarioAPP)
    {
        this.cuestionarioAPP = cuestionarioAPP;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void onAddPregunta(ActionEvent actionEvent) {
        pregunta = new Pregunta(fieldPregunta.getText(),Integer.parseInt(tiempo.getValue()+""),Integer.parseInt(fieldPuntos.getText()));

        pregunta.addRespuesta(fieldRespuesta1.getText());
        pregunta.addRespuesta(fieldRespuesta2.getText());
        pregunta.addRespuesta(fieldRespuesta3.getText());
        pregunta.addRespuesta(fieldRespuesta4.getText());
        cuestionario.addPregunta(pregunta);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Informacion");
        alert.setContentText("Se ha añadido la pregunta al cuestionario");
        alert.showAndWait();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> items = FXCollections.observableArrayList();
        items.addAll("5", "10", "15", "20");

        tiempo.setItems(items);
        pregunta =null;
    }
}
