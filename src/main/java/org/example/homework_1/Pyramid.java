package org.example.homework_1;

public class Pyramid implements Shape {
    private double volume, s,h;

    public Pyramid(double s, double h) {
        this.s = s;
        this.h = h;
    }

    public double getS() {
        return s;
    }

    public double getH() {
        return h;
    }

    @Override
    public double getVolume() {
        return this.volume;
    }
}
