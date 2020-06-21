package com.exam.se05;

import lombok.ToString;

import java.util.NoSuchElementException;

@ToString
public class Parent {

    private int field = 10;

    {
        System.out.println("Init-block 1");
    }

    public Parent(int field) throws NoSuchMethodException {
        if (field < 0) {
            throw new NoSuchMethodException();
        }
        this.field = field;
    }

    {
        System.out.println("Initial-Block 2: " + field);
    }

    public void process() throws RuntimeException {
        System.out.println("Parent::process");
    }
}

class Child extends Parent {
    Child(int value) throws NoSuchMethodException {
        super(value);
    }

    @Override
    public void process() throws RuntimeException {
        System.out.println("Child::process");
    }
}

class Launcher1 {
    public static void main(String[] args) {
        Parent parent = null;
        try{
            parent = new Child(-1);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(parent);
    }
}
