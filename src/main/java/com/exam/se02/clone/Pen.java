package com.exam.se02.clone;

import java.util.Objects;

public class Pen  implements Cloneable{
    private int price;
    private String manufatureName;

    @Override
    protected Pen clone() {
        try {
            return (Pen)super.clone();
        } catch (CloneNotSupportedException ignore) {
            throw new RuntimeException(ignore);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return price == pen.price &&
                Objects.equals(manufatureName, pen.manufatureName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, manufatureName);
    }

    public Pen(int price, String manufatureName) {
        this.price = price;
        this.manufatureName = manufatureName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getManufatureName() {
        return manufatureName;
    }

    public void setManufatureName(String manufatureName) {
        this.manufatureName = manufatureName;
    }

    public void showPen() {
        System.out.println("Manufature Name: " + manufatureName +
                "\nPrice: " + price);
    }

    @Override
    public String toString() {
        return "Pen{" +
                "price=" + price +
                ", manufatureName='" + manufatureName + '\'' +
                '}';
    }
}
