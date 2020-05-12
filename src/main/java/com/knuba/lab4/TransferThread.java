package com.knuba.lab4;

class TransferThread extends Thread {
    private final Bank bank;
    private int fromAccount;
    private int maxAmount;
    private static final int REPS = 1000;

    /**
     * @param b    the bank between whose account money is transferred
     * @param from the account to transfer money from
     * @param max  the maximum amount of money in each transfer
     */
    public TransferThread(Bank b, int from, int max) {
        bank = b;
        fromAccount = from;
        maxAmount = max;
    }

    public void run() {
        try {
            while (!interrupted()) {
                for (int i = 0; i < REPS; i++) {
                    int toAccount = (int) (bank.size() * Math.random());
                    int amount = (int) (maxAmount * Math.random() / REPS);
                    bank.transfer(fromAccount, toAccount, amount);
//                    sleep(i);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
