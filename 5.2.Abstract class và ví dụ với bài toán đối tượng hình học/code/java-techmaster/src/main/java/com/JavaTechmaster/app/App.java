package com.JavaTechmaster.app;

public class App {
    public static void main( String[] args ) {
        System.out.println("Abstract class examples");
        //Shape shape = new Shape();//Ko thể khởi tạo object từ abstract class
        //Nếu khởi tạo phải thực thi những phương thức còn thiếu
        Shape shape = new Shape("shape A") {
            @Override
            public double area() {
                return 0;
            }

            @Override
            public void draw() {

            }
        };
        Rectangle rectangle = new Rectangle("rect A", 120.0,130.0);
        System.out.println("Rectangle's area = " + rectangle.area());
        System.out.println("Circle calculation");
        Circle circle = new Circle("Circle A", 10.0);
        System.out.println("Circle's area = "+circle.area());
        //Cả Circle và Rectangle đều gọi được phương thức move của lớp cha(Shape)
        rectangle.moveTo(1,2);
        circle.moveTo(3,4);
    }
}
