package com.knuba.lab1.exercise3;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread thread = new Thread(new IncrementThread(counter));

        thread.start();

        thread.join();

        System.out.println();

        for ( int i = 0; i < 1000; i++) {
            System.out.print(counter.getValue() + " ");
            counter.decrement();
        }
    }

}
