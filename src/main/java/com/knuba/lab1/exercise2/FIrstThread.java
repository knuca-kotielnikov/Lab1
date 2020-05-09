package com.knuba.lab1.exercise2;

class FIrstThread implements Runnable {

    final private ResourceLock resourceLock;

    FIrstThread(ResourceLock resourceLock) {
        this.resourceLock = resourceLock;
    }

    @Override
    public void run() {
        synchronized (resourceLock) {
            for (int i = 0; i < 10; i++) {
                while (resourceLock.getFlag() != 1) {
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
                resourceLock.setFlag(2);
                resourceLock.notify();
            }
        }

    }
}
