package com.exam.se02.enums;

public enum Direction {
    FORWARD(1.0) {
        @Override
        public Direction opposite() {
            return BACKWARD;
        }
    },

    BACKWARD(2.0) {
        @Override
        public Direction opposite() {
            return FORWARD;
        }
    };

    public abstract Direction opposite();

    private double ratio;


    Direction(double ratio) {
        this.ratio = ratio;
    }

    public static Direction byRatio(double r) {
        if(r == 1.0) return FORWARD;
        else if(r == 2.0) return BACKWARD;
        else throw new IllegalArgumentException();
    }
}
