package com.knuba.lab1.exercise2;

public class SecondThread implements Runnable {

    final private ResourceLock resourceLock;

    SecondThread (ResourceLock resourceLock) {
        this.resourceLock = resourceLock;
    }

    @Override
    public void run() {
        synchronized (resourceLock) {
            for (int i = 0; i < 10; i++) {

                while (resourceLock.getFlag() != 2) {
                    try {
                        resourceLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(" | ");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                resourceLock.setFlag(1);
                resourceLock.notify();
            }
        }
    }
}
