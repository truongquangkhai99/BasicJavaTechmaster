package com.JavaTechmaster.app;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelDataManager {
    private Workbook workbook = new XSSFWorkbook();
    //Constructor
    ExcelDataManager() {
        Sheet sheet0 = workbook.createSheet("Points");
        Sheet sheet1 = workbook.createSheet("Temp");
        //Header row
        Row headerRow = sheet0.createRow(0);
        headerRow.createCell(0).setCellValue("X values");
        headerRow.createCell(1).setCellValue("Y values");
        headerRow.createCell(2).setCellValue("Sum");

    }
    public Workbook getWorkbook() {
        return workbook;
    }
    public void fillPointsToExcel(List<Point> points, String fileName) {
        Sheet sheet0 = workbook.getSheetAt(0);
        Integer rowNum = 1;
        for(Point point:points) {
            Row row = sheet0.createRow(rowNum++);
            row.createCell(0).setCellValue(point.getX());
            row.createCell(1).setCellValue(point.getY());
            //Có thể tính toán lấy kết quả lưu vào Excel
            Double sum = Double.valueOf(point.getX()) + Double.valueOf(point.getY());
            row.createCell(2).setCellValue(String.format("%.2f", sum));
        }
        try {
            FileOutputStream outputExcelFile = new FileOutputStream(fileName);
            workbook.write(outputExcelFile);
            outputExcelFile.close();
            workbook.close();
        } catch (Exception e) {
            if(e instanceof IOException) {
                System.out.println("Cannot read from file"+fileName);
            } else if(e instanceof FileNotFoundException) {
                System.out.println("Cannot find fil\"+fileName+\" to reade");
            }
        }
    }
}
