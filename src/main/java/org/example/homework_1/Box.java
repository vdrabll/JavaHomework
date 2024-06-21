package org.example.homework_1;

public class Box implements Shape {
    private double volume;

    public Box(double volume) {
        this.volume = volume;
    }

    @Override
    public double getVolume() {
        return this.volume;
    }

    public Boolean add(Shape shape) {
        if (shape.getVolume() < this.getVolume()) {
            return true;
        } else {
            return false;
        }
    }
}
