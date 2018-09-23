/*
Khoá học Java căn bản - Techmaster Vietnam
Trainer: Nguyễn Đức Hoàng
Bài: vẽ biếu đồ hình quạt với JavaFX
 */
package com.JavaTechmaster.app;
import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class App extends Application {
    ObservableList<PieChart.Data> pieChartData =
            FXCollections.observableArrayList(
                    new PieChart.Data("Apple iphone", 22),
                    new PieChart.Data("Samsung smartphones", 25),
                    new PieChart.Data("Huawei phones", 10),
                    new PieChart.Data("Nokia", 13),
                    new PieChart.Data("HTC smartphones", 30)
            );
    private PieChart pieChart = new PieChart(pieChartData);
    private Scene scene = new Scene(pieChart, 1200, 600);

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Example of pie chart");
        pieChart.setTitle("BarChart Example");
        pieChart.setLabelLineLength(10);
        pieChart.setLegendSide(Side.LEFT);
        primaryStage.setScene(scene);

        pieChartData.forEach(data -> {
            data.getNode().addEventHandler(
                    MouseEvent.MOUSE_PRESSED,
                    new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            String pieValue = String.valueOf(data.getPieValue()) + "%";
                            System.out.println(pieValue);
                        }
                    }
            );
        });
        primaryStage.show();
    }
    public static void main( String[] args ) {
        Application.launch(args);
    }

}
