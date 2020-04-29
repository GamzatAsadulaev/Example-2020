package com.exam.se02.clone;

import java.util.Arrays;
import java.util.Objects;

public class PencilCase implements Cloneable {
    private final Pen [] pens = new Pen[10];
    private int cursor = 0;


    public Pen[] getPens() {
        return pens;
    }

    public void add(Pen pen) {
        if(cursor == pens.length) {
            System.out.println("Array are full");
        } else {
            pens[cursor] = pen;
            cursor++;
        }
    }

    public void showPens() {
        for (int i = 0; i < cursor; i++) {
            pens[i].showPen();
        }
    }

    public boolean isEmpty() {
        return cursor == 0;
    }

    @Override
    public PencilCase clone(){
        try {
            PencilCase clone = (PencilCase)super.clone();
            Pen [] copyPens = Arrays.copyOf(this.pens, this.pens.length);
            for (int i = 0; i < copyPens.length; i++) {
                if(copyPens[i] != null) {
                    copyPens[i] = copyPens[i].clone();
                }
            }
            //clone.pens = copyPens;
            return clone;
        } catch (CloneNotSupportedException ignore) {
            throw new RuntimeException(ignore);
        }
    }

    public PencilCase m(){
        try {
            PencilCase clone = (PencilCase)super.clone();
            Pen [] copyPens = Arrays.copyOf(this.pens, this.pens.length);
            for (int i = 0; i < copyPens.length; i++) {
                if(copyPens[i] != null) {
                    copyPens[i] = copyPens[i].clone();
                }
            }
            for (int i = 0; i < copyPens.length; i++) {
                clone.pens[i] = copyPens[i].clone();
            }
            //clone.pens = copyPens;
            return clone;
        } catch (CloneNotSupportedException ignore) {
            throw new RuntimeException(ignore);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PencilCase that = (PencilCase) o;
        return cursor == that.cursor &&
                Arrays.equals(pens, that.pens);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(cursor);
        result = 31 * result + Arrays.hashCode(pens);
        return result;
    }
}

class Launcher {
    public static void main(String[] args) {
       PencilCase pencilCase = new PencilCase();

       pencilCase.add(new Pen(12, "Krause"));
       pencilCase.add(new Pen(15, "Yuguang"));

       pencilCase.showPens();

       PencilCase clone = pencilCase.clone();

       clone.getPens()[0].setPrice(20);
        System.out.println("Clone pens:");
       clone.showPens();

        System.out.println("\n\nParent Pens");
        pencilCase.showPens();


    }
}
