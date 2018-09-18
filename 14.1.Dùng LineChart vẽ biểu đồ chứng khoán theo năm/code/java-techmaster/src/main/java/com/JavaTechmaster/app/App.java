/*
Khoá học Java căn bản - Techmaster
Trainer: Nguyễn Đức Hoàng
 */
package com.JavaTechmaster.app;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class App extends Application {
    private NumberAxis xAxis = new NumberAxis();
    private NumberAxis yAxis = new NumberAxis();

    private LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
    private XYChart.Series seriesA = new XYChart.Series();
    private ObservableList<XYChart.Data> dataSeriesA = FXCollections.observableArrayList(
            new XYChart.Data(1, 25),
            new XYChart.Data(2, 24),
            new XYChart.Data(3, 17),
            new XYChart.Data(4, 26),
            new XYChart.Data(5, 33),
            new XYChart.Data(6, 32),
            new XYChart.Data(7, 20),
            new XYChart.Data(8, 42),
            new XYChart.Data(9, 41),
            new XYChart.Data(10, 19),
            new XYChart.Data(11, 28),
            new XYChart.Data(12, 24)
    );

    private XYChart.Series seriesB = new XYChart.Series();
    private ObservableList<XYChart.Data> dataSeriesB = FXCollections.observableArrayList(
            new XYChart.Data(1, 15),
            new XYChart.Data(2, 14),
            new XYChart.Data(3, 27),
            new XYChart.Data(4, 16),
            new XYChart.Data(5, 23),
            new XYChart.Data(6, 34),
            new XYChart.Data(7, 24),
            new XYChart.Data(8, 40),
            new XYChart.Data(9, 44),
            new XYChart.Data(10, 22),
            new XYChart.Data(11, 24),
            new XYChart.Data(12, 26)
    );

    private XYChart.Series seriesC = new XYChart.Series();
    private ObservableList<XYChart.Data> dataSeriesC = FXCollections.observableArrayList(
            new XYChart.Data(1, 10),
            new XYChart.Data(2, 22),
            new XYChart.Data(3, 9),
            new XYChart.Data(4, 7),
            new XYChart.Data(5, 15),
            new XYChart.Data(6, 20),
            new XYChart.Data(7, 22),
            new XYChart.Data(8, 16),
            new XYChart.Data(9, 30),
            new XYChart.Data(10, 16),
            new XYChart.Data(11, 20),
            new XYChart.Data(12, 21)
    );

    public static void main( String[] args ) {
        Application.launch(args);
    }
    private void configureGraph() {
        xAxis.setLabel("Months(1-12)");
        yAxis.setLabel("Points");
        lineChart.setTitle("Stock graph");

        seriesA.setName("Company A");
        //Muốn insert nhiều data => dùng
        seriesA.getData().addAll(dataSeriesA);
        lineChart.getData().addAll(seriesA);

        seriesB.setName("Company B");
        seriesB.getData().addAll(dataSeriesB);
        lineChart.getData().addAll(seriesB);

        seriesC.setName("Company C");
        seriesC.getData().addAll(dataSeriesC);
        lineChart.getData().addAll(seriesC);

        lineChart.getXAxis().setAutoRanging(true);
        lineChart.getYAxis().setAutoRanging(true);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("LineChart examples");
        configureGraph();
        Scene scene = new Scene(lineChart, 800,600);
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
