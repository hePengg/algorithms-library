package com.dap.Test.activelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {

    ReadWriteLock lock = new ReentrantReadWriteLock();

    public void write() {
        try {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getId() + " 持有写锁");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getId() + " 准备释放写锁");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void read() {
        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getId() + " 持有读锁");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getId() + " 准备释放读锁");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockDemo lockDemo = new ReentrantReadWriteLockDemo();

        new Thread(()->{
            lockDemo.write();
        }).start();

        new Thread(()->{
            lockDemo.write();
        }).start();
    }
}
