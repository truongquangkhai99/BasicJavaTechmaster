package com.JavaTechmaster.app;

public class Circle extends Shape{
    //Các thuộc tính thêm vào Shape
    Double radius;
    Circle(String name, Double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }

    @Override
    public double area() {
        return Math.PI*radius*radius;
    }
}
