package com.JavaTechmaster.app;

public class Point {
    private Double x;
    private Double y;
    Point(Double x, Double y) {
        this.x = x;
        this.y = y;
    }
    //getter/setter
    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(Double y) {
        this.y = y;
    }
}
