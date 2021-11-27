package com.example.visualizadorcolores;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class View extends VBox {

    private Label caja;
    private HBox filaUno;
    private HBox filaDos;
    private HBox filaTres;
    private Label colorUno;
    private Label colorDos;
    private Label colorTres;
    private Label numUno;
    private Label numDos;
    private Label numTres;
    private Slider deslizadorUno;
    private Slider deslizadorDos;
    private Slider deslizadorTres;
    private Controller control;

    public View(){

    initView();

    }

    public void initView(){

        this.setAlignment(Pos.CENTER);
        this.setPrefSize(180, 100);
        this.setMinSize(180, 100);
        this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

         caja = new Label ("");

         colorUno = new Label ("Red");
         colorUno.setMinWidth(32);

         colorDos = new Label("Green");
         colorDos.setMinWidth(32);

         colorTres = new Label("Blue");
         colorTres.setMinWidth(32);

         numUno = new Label("");
         numUno.setMinWidth(20);

         numDos = new Label("");
         numDos.setMinWidth(20);

         numTres = new Label("");
         numTres.setMinWidth(20);

         deslizadorUno = new Slider(0,255,128);
         deslizadorDos = new Slider(0,255,128);
         deslizadorTres = new Slider(0,255,128);

         filaUno = new HBox(colorUno, deslizadorUno, numUno);
         filaUno.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

         filaDos = new HBox(colorDos, deslizadorDos, numDos);
         filaDos.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

         filaTres = new HBox(colorTres, deslizadorTres, numTres);
         filaTres.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

         caja.prefWidthProperty().bind(this.widthProperty());
         caja.prefHeightProperty().bind(this.heightProperty().subtract(filaUno.getHeight()).multiply(3));
         deslizadorUno.prefWidthProperty().bind(
                this.widthProperty().subtract(numUno.getWidth()).subtract(colorUno.getWidth()));
         deslizadorDos.prefWidthProperty().bind(
                this.widthProperty().subtract(numDos.getWidth()).subtract(colorDos.getWidth()));
         deslizadorTres.prefWidthProperty().bind(
                this.widthProperty().subtract(numTres.getWidth()).subtract(colorTres.getWidth()));

         this.getChildren().addAll(caja, filaUno, filaDos, filaTres);

        control = new Controller(
                caja,
                deslizadorUno, numUno,
                deslizadorDos, numDos,
                deslizadorTres, numTres);
    }
}
