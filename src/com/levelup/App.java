package com.levelup;

import java.lang.Override;
import java.lang.Runnable;
import java.lang.System;
import java.lang.Thread;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("I'm a main thread:" + Thread.currentThread().getName());
//        App app = new App();
//        app.startThread();
          DBExample dbExample = new DBExample();
        dbExample.test();


    }

    private Thread createThread(Bank bank){
        return new MyThread(bank);
    }


    public void startThread(){
        //Thread thread = new Thread(new MyRunnable());
        Bank bank = new Bank();

       Thread t1 = createThread(bank);
        t1.start();
       Thread t2 = createThread(bank);
        t2.start();
       Thread t3 = createThread(bank);
        t3.start();
        Thread l = new MyListener(bank);
        l.start();

        try {
            Thread.currentThread().sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }


    private class MyThread extends Thread{
        private final Bank bank;
        private MyThread(Bank bank) {
            this.bank = bank;
        }

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()){
                       bank.transfer(Math.random()*1000);
                        sleep(5000);

                }
            } catch (InterruptedException e) {
                doSomething("Interrupted Thread name:");

            }
        }

        private void doSomething(String message){
            System.out.println(message + Thread.currentThread().getName());
        }
    }

    private class MyListener extends Thread{
        private final Bank bank;
        private MyListener(Bank bank) {
            this.bank = bank;
        }

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()){
                    System.out.println(bank.getCurrentAmount());
                    sleep(500);

                }
            } catch (InterruptedException e) {
                doSomething("Interrupted Thread name:");

            }
        }

        private void doSomething(String message){
            System.out.println(message + Thread.currentThread().getName());
        }
    }
}
