package com.exam.se04.serialization;

import java.io.*;


public class SomeReferenceSerialization {
    public static void main(String[] args) {
        Point p1 = new Point(1.0, 1.0);
        Point p2 = new Point(2.0, 2.0);
        Point p3 = new Point(3.0, 3.0);
        Line line1 = new Line(p1, p2, 1);
        Line line2 = new Line(p1, p2, 2);
        System.out.println("line 1 = " + line1);
        System.out.println("line 2 = " + line2);
        String fileName = "C:\\new\\serialization.dat";
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
            out.writeObject(line1);

            out.reset();

            line1.setIndex(3);

            out.writeObject(line1);

            System.out.println("Read object");

            Line line_1 = (Line) in.readObject();
            line_1.printInfo();

            Line line_2 = (Line) in.readObject();
            line_2.printInfo();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
