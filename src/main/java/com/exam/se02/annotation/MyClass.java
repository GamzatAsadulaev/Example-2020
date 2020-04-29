package com.exam.se02.annotation;


import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * My super-class
 * @author Gamzat
 */
@Getter
@Setter
@MyAnnotation(param = "abc")
public class MyClass {
    @MyAnnotation(param = "---")
    private int field;
    private final boolean active = true;


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Object object = new MyClass();

        Class<?> clazz = object.getClass();
        System.out.println(clazz.isAnnotationPresent(MyAnnotation.class));
        System.out.println(clazz.isAnnotationPresent(Setter.class));

        MyAnnotation fieldAnnotation = clazz.getAnnotation(MyAnnotation.class);
        System.out.println(fieldAnnotation.param());
        Field field = clazz.getDeclaredField("field");
        MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.param());
    }

    private static void example01() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        Object object = new MyClass();
        Class<?> clazz = object.getClass();
        Method sayHello = clazz.getMethod("sayHello");

        sayHello.invoke(object);

//        Class<Boolean> booleanClass = boolean.class;
//        Method setterActive = clazz.getMethod("setActive", booleanClass);
//        setterActive.invoke(object, true);

//        Method getterActive = clazz.getMethod("isActive");
//        System.out.println(getterActive.invoke(object));

//        Object object2 = new MyClass();
//
//        Class<?> clazz2 = object2.getClass();
//        Method getRandomNumber = clazz.getMethod("getRandomNumber", int.class, int.class);
//        System.out.println(getRandomNumber.invoke(object2, 10, 10));

//        Field field = clazz.getField("field");
//        System.out.println(field.get(object));
        Field declaredField = clazz.getDeclaredField("active");
        declaredField.setAccessible(true);
        declaredField.set(object, false);
        System.out.println(declaredField.get(object));
    }

    public static void sayHello() {
        System.out.println("Hello");
    }

    public static int getRandomNumber(int min, int max) {
        return (int)(Math.random() * min * max);
    }
}
