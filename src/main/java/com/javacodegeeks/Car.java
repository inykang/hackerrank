package com.javacodegeeks;

public class Car extends Vehicle {
    public Car(Workshop w1, Workshop w2) {
        super(w1, w2);
    }

    @Override
    public void manufacture() {
        System.out.println("Car");
        w1.work();
        w2.work();
    }
}
