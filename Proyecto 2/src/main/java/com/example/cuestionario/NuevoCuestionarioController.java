package com.example.cuestionario;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NuevoCuestionarioController implements Initializable {

    private CuestionarioAPP cuestionarioAPP ;

    private Cuestionario cuestionario ;

    @FXML
    private TextField fieldTitulo;

    @FXML
    private TextField fieldDesc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
    public  void setCuestionarioAPP(CuestionarioAPP cuestionarioAPP)
    {
        this.cuestionarioAPP = cuestionarioAPP;
    }

    public Cuestionario getCuestionario() {
        return cuestionario;
    }

    public void onActionCancelar(ActionEvent actionEvent) {

    }

    public void onActionSiguiente(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("DetalleDelCuestionario.fxml"));
        Parent root = fxmlLoader.load();
        DetalleDelCuestionarioController controller = fxmlLoader.getController();

        controller.setCuestionarioAPP(this.cuestionarioAPP);
        cuestionario = new Cuestionario(fieldTitulo.getText(),fieldDesc.getText());
        controller.setCuestionario(cuestionario);

        cuestionarioAPP.getListaCuestionarios().addCuestionario(cuestionario);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }

}
