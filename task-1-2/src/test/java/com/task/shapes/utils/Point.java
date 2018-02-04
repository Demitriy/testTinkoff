package com.task.shapes.utils;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point add(Point point) {
        return new Point(this.x + point.x, this.y + point.y);
    }

    public Point sub(Point point) {
        return new Point(this.x - point.x, this.y - point.y);
    }

    public Point mul(Integer val) {
        return new Point(this.x * val, this.y * val);
    }

    public Double getLength() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    public Double product(Point point) {
        return Double.valueOf(this.x * point.getX() + this.y * point.getY());
    }
}
