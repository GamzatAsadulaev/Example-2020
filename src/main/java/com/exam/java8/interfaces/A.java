package com.exam.java8.interfaces;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public interface A {
    default void callMe() {
        System.out.println("A");
    }
}

interface B {
    default void callMe() {
        System.out.println("B");
    }
}

class D {
    void callMe() {
        System.out.println("D");
    }
}

class C extends D implements A, B {

    @Override
    public void callMe() {
        System.out.println("From C");
        super.callMe(); // Обращаемся к методу базового класса
        A.super.callMe();// обращаемся к default методу интерфейса А от которого наследовались
        B.super.callMe();// обращаемся к default методу интерфейса B от которого наследовались
    }
}

class Launcher1 {
    public static void main(String[] args) {
        C c = new C();
        c.callMe();
    }
}
