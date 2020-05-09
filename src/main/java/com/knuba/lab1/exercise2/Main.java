package com.knuba.lab1.exercise2;

class Main {

    public static void main(String[] args) throws InterruptedException {
            ResourceLock lock = new ResourceLock();

        for(int i = 0; i < 10; i++) {
            Thread firstThread = new Thread(new FIrstThread(lock));
            Thread secondThread = new Thread(new SecondThread(lock));

            firstThread.start();
            secondThread.start();

            firstThread.join();
            secondThread.join();

            System.out.println();
        }
    }
}
