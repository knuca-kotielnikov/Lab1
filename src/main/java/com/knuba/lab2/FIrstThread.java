package com.knuba.lab2;

import static java.lang.Thread.sleep;

public class FIrstThread implements Runnable {

    private ResourceLock resourceLock;

    public FIrstThread(ResourceLock resourceLock) {
        this.resourceLock = resourceLock;
    }

    @Override
    public void run() {
        synchronized (resourceLock) {
            for (int i = 0; i < 10; i++) {
                while (resourceLock.flag != 1) {
                    try {
                        resourceLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(" - ");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                resourceLock.flag = 2;
                resourceLock.notify();
            }
        }

    }
}
