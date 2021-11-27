package com.example.visualizadorcolores;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class Controller {

    private Label colorBox;
    private Label numRed, numGreen, numBlue;
    private Slider sliderRed, sliderGreen, sliderBlue;
    private IntegerProperty valueRed, valueGreen, valueBlue;

    public Controller(Label coloBox, Slider sliderRed, Label numRed, Slider sliderGreen, Label numGreen,
        Slider sliderBlue, Label numBlue){

        this.colorBox = coloBox;

        this.sliderRed = sliderRed;
        this.numRed = numRed;

        this.sliderGreen = sliderGreen;
        this.numGreen = numGreen;

        this.sliderBlue = sliderBlue;
        this.numBlue = numBlue;

        valueRed =new SimpleIntegerProperty();
        valueGreen =new SimpleIntegerProperty();
        valueBlue =new SimpleIntegerProperty();

        numRed.textProperty().bind(valueRed.asString());
        numGreen.textProperty().bind(valueGreen.asString());
        numBlue.textProperty().bind(valueBlue.asString());

        valueRed.bind(sliderRed.valueProperty());
        valueGreen.bind(sliderGreen.valueProperty());
        valueBlue.bind(sliderBlue.valueProperty());

        valueRed.addListener((v, ov, nv)-> changeColor());
        valueGreen.addListener((v, ov, nv)-> changeColor());
        valueBlue.addListener((v, ov, nv)-> changeColor());

    }

    // Metodo cambiar color
    private void changeColor() {
        colorBox.setBackground(new Background(new BackgroundFill
                (Color.rgb(valueRed.get(), valueGreen.get(), valueBlue.get()), null, null)));
    }
}