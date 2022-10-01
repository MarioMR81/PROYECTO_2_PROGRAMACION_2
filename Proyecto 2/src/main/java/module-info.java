module com.example.cuestionario {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires itextpdf;
    requires java.desktop;

    opens com.example.cuestionario to javafx.fxml;
    exports com.example.cuestionario;
}