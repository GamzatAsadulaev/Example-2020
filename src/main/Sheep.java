package main;

public class Sheep {
    private String name;
    private int age;
    private double weight;


    public Sheep(String name, int age, double weight) throws IllegalArgumentException, IllegalAccessError {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }


}
