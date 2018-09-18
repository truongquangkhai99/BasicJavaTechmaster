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
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;

public class App extends Application {
    private NumberAxis xAxis = new NumberAxis();
    private NumberAxis yAxis = new NumberAxis();

    private LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
    private XYChart.Series seriesA = new XYChart.Series();
    private ObservableList<XYChart.Data> dataSeriesA = FXCollections.observableArrayList();
    Workbook workbook;

    public static void main( String[] args ) {
        Application.launch(args);
    }
    private Double getCellValue(Cell cell) {
        switch (cell.getCellTypeEnum()) {
            case NUMERIC:
                return cell.getNumericCellValue();
            default:
                return 0.0;
        }
    }
    private void configureGraph() {
        xAxis.setLabel("Months(1-12)");
        yAxis.setLabel("Points");
        lineChart.setTitle("Stock graph");

        seriesA.setName("Company A");
        try {
            workbook = WorkbookFactory.create(new File("src/main/resources/sample-excel.xlsx"));
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        workbook.forEach(sheet -> {
            System.out.println("Sheet's name : "+sheet.getSheetName());
        });
        Sheet firstSheet = workbook.getSheetAt(0);
        firstSheet.forEach(row ->{
            if(row.getRowNum() == 0) {
                return;
            }
            XYChart.Data newXY = new XYChart.Data<Double, Double>(
                    //Giá trị x, y lấy ở
                    getCellValue(row.getCell(0)),
                    getCellValue(row.getCell(1))
            );
            dataSeriesA.add(newXY);
        });
        seriesA.getData().addAll(dataSeriesA);
        lineChart.getData().addAll(seriesA);

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
