package com.exam.se04.serialization;

import java.io.*;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

public class A implements Serializable {
    private static final long serialVersionUID = -6709136520406604035L;

    private int field;
    private String str;

    public A(int field, String str) {
        this.field = field;
        this.str = str;
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "A{" +
                "field=" + field +
                ", str='" + str + '\'' +
                '}';
    }
}

class Launcher {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        A object = new A(42, "abc");
//        System.out.println(object);

//        String file = "./../a.dat";
//        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
//            out.writeObject(object);
//        System.out.println(object.getField());
//        System.out.println(object.getStr());
//        }

        InputStream resourceStream = Launcher.class.getResourceAsStream("/b.dat");
        System.out.println(resourceStream);
        try(ObjectInputStream in = new ObjectInputStream(resourceStream)) {
            A deserializationObject = (A) in.readObject();
            System.out.println(deserializationObject);
            System.out.println(deserializationObject.getField());
            System.out.println(deserializationObject.getStr());
        }
    }
}
