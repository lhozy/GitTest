package com.lh.t2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableImpl implements Runnable{
    private Integer tickets = 100;
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            lock.lock();//加锁
            if(tickets > 0){
                try {
                    Thread.sleep(1);
                    System.out.println(Thread.currentThread().getName()+":第"+tickets+"张票");
                    tickets--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();//释放锁
                }
            }

        }

    }
}
