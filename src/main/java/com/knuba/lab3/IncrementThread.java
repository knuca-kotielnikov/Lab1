package com.knuba.lab3;

public class CustomThread implements Runnable {

    Counter counter;

    public CustomThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized ()
    }
}
