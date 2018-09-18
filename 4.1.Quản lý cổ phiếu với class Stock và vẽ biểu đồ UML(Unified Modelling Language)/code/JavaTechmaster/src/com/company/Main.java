/*
Khoá học Java căn bản - Techmaster
Trainer: Nguyễn Đức Hoàng
Quản lý cổ phiếu với class Stock và vẽ biểu đồ UML(Unified Modelling Language)
 */
package com.company;

import java.text.DecimalFormat;

class Stock {
    private String symbol; //Mã chứng khoán, VD: ORCL là Oracle Corporation
    private String companyName; //VD: Oracle Corporation
    private double previousClosingPrice;
    private double currentPrice;
    //Constructor - Hàm khởi tạo
    Stock(String symbol, String companyName) {
        this.symbol = symbol;
        this.companyName = companyName;
    }
    double getChangePercent() {
        double percent = ((currentPrice-previousClosingPrice)/previousClosingPrice) * 100;
        //Làm tròn, lấy 2 số sau dấu phảy
        DecimalFormat format = new DecimalFormat("#.##");
        return Double.valueOf(format.format(percent));
    }
    //Các hàm setter
    void setPreviousClosingPrice(double newValue) {
        previousClosingPrice = newValue;
    }
    void setCurrentPrice(double newValue) {
        currentPrice = newValue;
    }
}
public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock("ORCL", "Oracle Corporation");
        stock.setPreviousClosingPrice(122.0);
        stock.setCurrentPrice(100.0);
        System.out.println(stock.getChangePercent());
    }
}
