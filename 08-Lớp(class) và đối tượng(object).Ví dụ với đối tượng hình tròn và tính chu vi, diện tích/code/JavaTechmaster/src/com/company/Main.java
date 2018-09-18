/*
Khoá học Java căn bản - Techmaster
Trainer: Nguyễn Đức Hoàng
 */
package com.company;

//Định nghĩa class
class Circle {
    private double radius;//Trường = "thuộc tính" = field
    float x, y; //Toạ độ tâm x, y
    //Hàm khởi tạo = constructor = trùng với tên class
    Circle() {
        //Gọi sau khi khởi tạo đối tượng(object)
        System.out.println("This is a constructor");
    }
    //Hàm khởi tạo tuỳ biến = "custom constructor"
    Circle(double newRadius) {
        System.out.println("This is a custom constructor");
        this.radius = newRadius;
    }
    //Phương thức = method
    double getArea() {
        return radius * radius * Math.PI;
    }
    double getRadius() {
        //Getter
        return radius;
    }
    //Setter, Giả sử muốn set giá trị của trường radius nhưng radius lại là "private" ?
    void setRadius(double newRadius) {
        radius = newRadius;
    }
}

public class Main {
    public static void main(String[] args) {
        //Khởi tạo đối tượng(object)
        //Circle circle = new Circle();
        Circle circle = new Circle(10.0);
//        System.out.println("radius = "+circle.radius);//Không truy cập được private field
        double area = circle.getArea();
        System.out.printf("area = %.2f", area);
        //circle.radius = 120.0;//Không được bởi vì radius là private
        circle.setRadius(120.0);
        System.out.println("radius = "+circle.getRadius());
    }
}
