package com.knuba.lab2;

import static java.lang.Thread.sleep;

public class SecondThread implements Runnable {

    private ResourceLock resourceLock;

    public SecondThread (ResourceLock resourceLock) {
        this.resourceLock = resourceLock;
    }

    @Override
    public void run() {
        synchronized (resourceLock) {
            for (int i = 0; i < 10; i++) {

                while (resourceLock.flag != 2) {
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
                resourceLock.flag = 1;
                resourceLock.notify();
            }
        }
    }
}
