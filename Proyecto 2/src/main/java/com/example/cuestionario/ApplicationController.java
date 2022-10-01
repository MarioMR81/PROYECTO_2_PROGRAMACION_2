package com.example.cuestionario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class
ApplicationController implements Initializable {
    @FXML
    private TableView<Cuestionario> table;

    @FXML
    private TableColumn columnPin;

    @FXML
    private TableColumn columnNombre;

    @FXML
    private TableColumn columnDescripcion;

    private CuestionarioAPP cuestionarioAPP = new CuestionarioAPP();

    private ObservableList<Cuestionario> cuestionarios;

     @Override
     public void initialize(URL url, ResourceBundle rb)
     {
         cuestionarios = FXCollections.observableArrayList();
         this.table.setItems(cuestionarios);

         this.columnPin.setCellValueFactory(new PropertyValueFactory("pin"));
         this.columnNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
         this.columnDescripcion.setCellValueFactory(new PropertyValueFactory("descripcion"));

         List<Cuestionario> lista = cuestionarioAPP.getListaCuestionarios().getCuestionarios();
         for (Cuestionario e:lista) {
             cuestionarios.add(e);
         }

     }
    public void onActivarButtonClick(ActionEvent actionEvent) {

    }

    public void onAddButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("NuevoCuestionario.fxml"));
        Parent root = fxmlLoader.load();
        NuevoCuestionarioController controller = fxmlLoader.getController();
        controller.setCuestionarioAPP(this.cuestionarioAPP);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();

        if(controller.getCuestionario()!=null)
        {
            cuestionarios.add(controller.getCuestionario());
            table.refresh();
        }
    }


    public void onTopButtonClick(ActionEvent actionEvent) {
        cuestionarioAPP.generarTop("Programacion");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Informacion");
        alert.setContentText("PDF generado con el top");
        alert.showAndWait();
    }
}