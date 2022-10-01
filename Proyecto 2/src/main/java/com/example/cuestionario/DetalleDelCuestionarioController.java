package com.example.cuestionario;

import  javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DetalleDelCuestionarioController implements Initializable {

    @FXML
    private TableView<Pregunta> table;

    @FXML
    private TableColumn colPregunta;

    @FXML
    private TableColumn colTiempo;

    @FXML
    private TableColumn colPunteo;
    @FXML
    private Label labelTitulo;

    @FXML
    private Label labelDesc;

    private CuestionarioAPP cuestionarioAPP;

    private Cuestionario cuestionario ;

    private ObservableList<Pregunta> preguntas;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        preguntas = FXCollections.observableArrayList();
        this.table.setItems(preguntas);

        this.colPregunta.setCellValueFactory(new PropertyValueFactory("pregunta"));
        this.colTiempo.setCellValueFactory(new PropertyValueFactory("tiempoLimite"));
        this.colPunteo.setCellValueFactory(new PropertyValueFactory("puntos"));

    }

    public void setCuestionario(Cuestionario cuestionario)
    {
        this.cuestionario = cuestionario;
        labelTitulo.setText(cuestionario.getNombre());
        labelDesc.setText(cuestionario.getDescripcion());
    }
    public  void setCuestionarioAPP(CuestionarioAPP cuestionarioAPP)
    {
        this.cuestionarioAPP = cuestionarioAPP;
    }

    public void onActionAddPregunta(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("NuevaPregunta.fxml"));
        Parent root = fxmlLoader.load();

        NuevaPreguntaController controller = fxmlLoader.getController();
        controller.setCuestionarioAPP(this.cuestionarioAPP);
        controller.setCuestionario(this.cuestionario);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();

        if(controller.getPregunta()!=null)
        {
            preguntas.add(controller.getPregunta());
            table.refresh();
        }
    }

}
