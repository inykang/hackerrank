package com.javacodegeeks;

abstract class Vehicle {
    protected Workshop w1;
    protected Workshop w2;

    protected Vehicle(Workshop w1, Workshop w2)
    {
        this.w1 = w1;
        this.w2 = w2;
    }
    abstract public void manufacture();

}
