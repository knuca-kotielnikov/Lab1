package com.knuba.lab1.exercise3;

public class IncrementThread implements Runnable {

    private Counter counter;

    public IncrementThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
            System.out.print(counter.getValue() + " ");
        }
    }
}
