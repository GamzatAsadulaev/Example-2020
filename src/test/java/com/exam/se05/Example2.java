package com.exam.se05;

import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;

public class Example2 {

    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("com.exam.se05.Example2.Nested");
            Constructor<?> constructor = clazz.getConstructor();
            constructor.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        Function<String, String> readFile = Example2::readFile;

        String content = readFile.apply("text.txt");
        processContent(content);
    }

    @SneakyThrows
    private static String readFile(String fileName) {
        // TODO read file
        if(true) {
            throw new FileNotFoundException(fileName);
        }
        return "123";
    }

    private static void processContent(String content) {
        // ...
    }
}

abstract class Nested {
    public Nested() {
        System.out.println("Nested::ctor");
    }
}
