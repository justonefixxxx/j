package com.accounts;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Bank {

    private ReentrantLock lock = new ReentrantLock();
    private double amount=10000;

      public void transfer(double transferAmount){
            lock.lock();
            if (transferAmount<getCurrentAmount()) {
                amount-=transferAmount;
                System.out.println("Name=" +Thread.currentThread().getName()+"Transferred " + transferAmount +"$, available "+amount+"$");
            }

            lock.unlock();
    }

     public double getCurrentAmount(){


         double current = amount;
         return current;
    }
}
