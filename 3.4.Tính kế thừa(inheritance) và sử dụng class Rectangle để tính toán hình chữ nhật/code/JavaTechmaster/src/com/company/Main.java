/*
Khoá học Java căn bản - Techmaster
Trainer: Nguyễn Đức Hoàng
Tính kế thừa(inheritance) và sử dụng class Rectangle để tính toán hình chữ nhật
 */
package com.company;

import java.util.Date;

class Geometry {//Đây là "lớp cha" = parent class = superclass
    private String color;
    private Boolean isFilled;
    private Date createdDate;
    //Getter/setter
    String getColor() {
        return this.color;
    }
    void setColor(String color) {
        this.color = color;
    }
    Geometry(String color, Boolean isFilled) {
        this.color = color;
        this.isFilled = isFilled;
        this.createdDate = new Date();
        System.out.printf("Constructor in Geometry, with color: %s, " +
                "isFilled = %b at: %s\n", color, isFilled, this.createdDate);
    }
    void showSomething(int x){
        System.out.printf("x = %d", x);
    }
}
class Rectangle extends Geometry {//Đây là "lớp con" = subclass
    double width;
    double height;
    //Kế thừa hàm khởi tạo
    Rectangle(String color, Boolean isFilled, double width, double height) {
        super(color, isFilled);
        this.width = width;
        this.height = height;
        System.out.println("Constructor in Rectangle");
    }
    //Ghi đè(override) phương thức getColor của lớp cha(Geometry)

    @Override
    String getColor() {
        return super.getColor() + " of Rectangle";
    }
    //overload(nạp chồng) một phương thức public
    void showSomething(String s){
        System.out.printf("s = %s", s);
    }
}
public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle("red", true, 100, 40);
        System.out.println(rectangle.getColor());
        //Tạo môt đối tượng của class Geometry(lớp con)
        Geometry geometry = new Geometry("red", true);
        geometry.showSomething(123);
        rectangle.showSomething("hello");
    }
}
