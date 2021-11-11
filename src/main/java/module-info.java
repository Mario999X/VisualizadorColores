module com.example.visualizadorcolores {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.visualizadorcolores to javafx.fxml;
    exports com.example.visualizadorcolores;
}