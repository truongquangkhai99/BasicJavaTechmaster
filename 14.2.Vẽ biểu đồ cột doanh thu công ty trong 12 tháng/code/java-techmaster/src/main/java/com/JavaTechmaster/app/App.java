/*
Khoá học Java căn bản - Techmaster
Trainer: Nguyễn Đức Hoàng
 */
package com.JavaTechmaster.app;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.*;
import javafx.stage.Stage;

public class App extends Application {
    private CategoryAxis xAxis = new CategoryAxis();
    private NumberAxis yAxis = new NumberAxis();
    private BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);

    private XYChart.Series seriesA = new XYChart.Series();
    private ObservableList<Data> dataA = FXCollections.observableArrayList(
            new Data("January", 250.36),
            new Data("February", 270.22),
            new Data("March", 290.32),
            new Data("April", 320.36),
            new Data("May", 210.64),
            new Data("June", 250.36),
            new Data("July", 350.65),
            new Data("August", 400.54),
            new Data("September", 310.98),
            new Data("October", 200.35),
            new Data("November", 230.74),
            new Data("December", 300.66)
    );
    private Series seriesB = new XYChart.Series();
    private final ObservableList<Data> dataB = FXCollections.observableArrayList(
            new Data("January", 360.36),
            new Data("February", 400.40),
            new Data("March", 169.56),
            new Data("April", 230.69),
            new Data("May", 240.32),
            new Data("June", 410.16),
            new Data("July", 450.98),
            new Data("August", 200.6),
            new Data("September", 180.76),
            new Data("October",190.06),
            new Data("November",210.67),
            new Data("December",220.66)
    );


    public static void main( String[] args ) {
        Application.launch(args);
    }
    private void configureGraph() {
        xAxis.setLabel("Months(1-12)");
        yAxis.setLabel("Millions");
        barChart.setTitle("Bar chart example");

        //Series A
        seriesA.setName("Company A");
        seriesA.getData().addAll(dataA);

        //Series B
        seriesB.setName("Company B");
        seriesB.getData().addAll(dataB);

        barChart.getData().addAll(seriesA, seriesB);
        barChart.getXAxis().setAutoRanging(true);
        barChart.getYAxis().setAutoRanging(true);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Barchart examples");
        configureGraph();
        Scene scene = new Scene(barChart, 1200, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
