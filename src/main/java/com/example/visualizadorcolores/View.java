package com.example.visualizadorcolores;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class View extends VBox {

    private Label colorBox;
    private HBox rowOne, rowTwo, rowThree;
    private Label redColorText, greenColorText, blueColorText;
    private Label numRed, numGreen, numBlue;
    private Slider sliderRed, sliderGreen, sliderBlue;
    private Controller control;


    public View(){initView();}


    public void initView(){

        this.setAlignment(Pos.CENTER);
        this.setPrefSize(180, 100);
        this.setMinSize(180, 100);
        this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

         colorBox = new Label ("");

         redColorText = new Label ("Red");
         redColorText.setMinWidth(32);

         greenColorText = new Label("Green");
         greenColorText.setMinWidth(32);

         blueColorText = new Label("Blue");
         blueColorText.setMinWidth(32);

         numRed = new Label("");
         numRed.setMinWidth(20);

         numGreen = new Label("");
         numGreen.setMinWidth(20);

         numBlue = new Label("");
         numBlue.setMinWidth(20);

         sliderRed = new Slider(0,255,128);
         sliderGreen = new Slider(0,255,128);
         sliderBlue = new Slider(0,255,128);

         rowOne = new HBox(redColorText, sliderRed, numRed);
         rowOne.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

         rowTwo = new HBox(greenColorText, sliderGreen, numGreen);
         rowTwo.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

         rowThree = new HBox(blueColorText, sliderBlue, numBlue);
         rowThree.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

         colorBox.prefWidthProperty().bind(this.widthProperty());
         colorBox.prefHeightProperty().bind(this.heightProperty().subtract(rowOne.getHeight()).multiply(3));
         sliderRed.prefWidthProperty().bind(
                this.widthProperty().subtract(numRed.getWidth()).subtract(redColorText.getWidth()));
         sliderGreen.prefWidthProperty().bind(
                this.widthProperty().subtract(numGreen.getWidth()).subtract(greenColorText.getWidth()));
         sliderBlue.prefWidthProperty().bind(
                this.widthProperty().subtract(numBlue.getWidth()).subtract(blueColorText.getWidth()));

         this.getChildren().addAll(colorBox, rowOne, rowTwo, rowThree);

        control = new Controller(
                colorBox,
                sliderRed, numRed,
                sliderGreen, numGreen,
                sliderBlue, numBlue);
    }
}
