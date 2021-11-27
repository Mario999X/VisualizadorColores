package com.example.visualizadorcolores;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class Controller {

    private Label caja;
    private Label colorUno;
    private Label colorDos;
    private Label colorTres;
    private Label numUno;
    private Label numDos;
    private Label numTres;
    private Slider deslizadorUno;
    private Slider deslizadorDos;
    private Slider deslizadorTres;
    private IntegerProperty valorUno, valorDos, valorTres;

    public Controller(Label caja, Slider deslizadorUno, Label numUno, Slider deslizadorDos, Label numDos,
        Slider deslizadorTres, Label numTres){

        this.caja = caja;

        this.deslizadorUno = deslizadorUno;
        this.numUno = numUno;

        this.deslizadorDos = deslizadorDos;
        this.numDos = numDos;

        this.deslizadorTres = deslizadorTres;
        this.numTres = numTres;

        valorUno=new SimpleIntegerProperty();
        valorDos=new SimpleIntegerProperty();
        valorTres=new SimpleIntegerProperty();

        numUno.textProperty().bind(valorUno.asString());
        numDos.textProperty().bind(valorDos.asString());
        numTres.textProperty().bind(valorTres.asString());

        valorUno.bind(deslizadorUno.valueProperty());
        valorDos.bind(deslizadorDos.valueProperty());
        valorTres.bind(deslizadorTres.valueProperty());

        valorUno.addListener((v, ov, nv)->cambioColor());
        valorDos.addListener((v, ov, nv)->cambioColor());
        valorTres.addListener((v, ov, nv)->cambioColor());

    }

    private void cambioColor() {
        caja.setBackground(new Background(new BackgroundFill
                (Color.rgb(valorUno.get(), valorDos.get(), valorTres.get()), null, null)));
    }
}