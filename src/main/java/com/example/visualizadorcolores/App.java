package com.example.visualizadorcolores;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new View(), 720, 540);
        stage.setTitle("Controlador de colores");
        stage.setScene(scene);
        stage.show();
    }

    // ES NECESARIO DESPLAZAR ALGUN DESLIZADOR PARA QUE APAREZCA UN COLOR

    public static void main(String[] args) {
        launch();
    }
}