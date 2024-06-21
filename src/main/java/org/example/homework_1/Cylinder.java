package org.example.homework_1;

public class Cylinder implements SolidORevolution{

    private double radius, volume;

    public Cylinder(double radius, double volume) {
        this.radius = radius;
        this.volume = volume;
    }

    @Override
    public double getRadius() {
        return this.radius;
    }

    @Override
    public double getVolume() {
        return this.volume;
    }
}
