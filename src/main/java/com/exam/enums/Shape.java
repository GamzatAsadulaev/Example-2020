package com.exam.enums;

public enum Shape {
    RECTANGLE("red"), TRIANGLE("green"),
    CIRCLE("blue");

    String color;
    Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}