package com.JavaTechmaster.app;

abstract class Shape {
    //Abstract class có thể chứa thuộc tính(fields)
    String name;
    Double x, y;
    //Constructor
    Shape(String name) {
        this.name = name;
    }
    //Non-abstract method
    public void moveTo(int x, int y) {
        System.out.println(this.name+" is moving from x = "+x+", y ="+y);
    }
    // abstract methods => Lớp con phải thực thi các phương thúc này
    abstract public double area();
    abstract public void draw();
}
