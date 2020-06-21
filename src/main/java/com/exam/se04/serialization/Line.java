package com.exam.se04.serialization;

import java.io.Serializable;

public class Line implements Serializable {
    private Point point1;
    private Point point2;
    private int index;

    public Line(Point point1) {
        System.out.println("Constructing empty line");
    }

    public Line(Point point1, Point point2, int index) {
        System.out.println("Constructing empty line");
        this.point1 = point1;
        this.point2 = point2;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void printInfo() {
        System.out.println("Line: " +  index);
        System.out.println("Object reference: " +  super.toString());
        System.out.println(" from point " + point1);
        System.out.println(" to point " + point2);
    }
}
