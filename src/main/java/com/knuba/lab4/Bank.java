package com.knuba.lab4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Bank {

    private static final int NTEST = 10000;
    private final int[] accounts;
    private long ntransacts = 0;
    private final Lock locker = new ReentrantLock();

    /**
     @param n the number of accounts
     @param initialBalance the initial balance
     for each account
     */
    public Bank(int n, int initialBalance){
        accounts = new int[n];
        int i;
        for (i = 0; i < accounts.length; i++)
            accounts[i] = initialBalance;
        ntransacts = 0;
    }
    /**
     Sparam from the account to transfer from
     cparam to the account to transfer to
     @param amount the amount to transfer
     */
    public void transfer(int from, int to, int amount) throws InterruptedException{
        locker.lock();
        accounts[from] -= amount;
        accounts[to] += amount;
        ntransacts++;
        if (ntransacts % NTEST == 0)
            test();
        locker.unlock();
    }
    public void test(){
        int sum = 0;
        for (int i = 0; i < accounts.length; i++)
            sum += accounts[i] ;
        System.out.println("Transactions:" + ntransacts
                + " Sum: " + sum);
    }
    /**
     @return the number of accounts
     */
    public int size(){
        return accounts.length;
    }
}
