package com.knuba.lab1.exercise2;

class ResourceLock{

    private volatile int flag = 1;

    int getFlag() {
        return flag;
    }

    void setFlag(int flag) {
        this.flag = flag;
    }
}
