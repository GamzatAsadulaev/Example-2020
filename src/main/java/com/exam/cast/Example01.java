package com.exam.cast;

public class Example01 {
    public static void main(String[] args) {
        A a_b = new B();
        B b = new B();

        A a = new A();
        B b_a = (B) a_b; //Валдиное преобразование
                         //Ссылка a_b Указывает на объект подкласса

        //B b__a = (B)a; //ClassCastException
                         //Не валидное преобразование
                         // Ссылка а указывает на объек суперкласса
    }
}


class A {
    public void info() {
        System.out.println("A");
    }
}
class B  extends  A{
    @Override
    public void info() {
        System.out.println("B");
    }
}

class C extends B{
    @Override
    public void info() {
        System.out.println("C");
    }
}