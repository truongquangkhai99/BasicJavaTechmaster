package com.JavaTechmaster.app;

public class Rectangle extends Shape{
    //Các thuộc tính thêm vào Shape
    Double width;
    Double height;

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
    //Constructor
    Rectangle(String name, Double width, Double height) {
        super(name);
        this.width = width;
        this.height = height;
    }
}
