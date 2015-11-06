package _16_read_write_lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReadWriteLock {

    public static class ReadWriteLockList {

        private List<Integer> list = new ArrayList<>();
        private Lock readLock = new ReentrantLock();
        private Lock writeLock = new ReentrantLock();

        public void addFirst(Integer item) {
            readLock.lock();
            writeLock.lock();

            try {
                list.add(0, item);
            } finally {
                readLock.unlock();
                writeLock.unlock();
            }
        }

        public void removeFirst() {
            readLock.lock();
            writeLock.lock();

            try {
                list.remove(0);
            } finally {
                readLock.unlock();
                writeLock.unlock();
            }
        }

        public int getFirst() {
            writeLock.lock();
            try {
                return list.get(0);
            } finally {
                writeLock.unlock();
            }
        }

        public int getSize() {
            writeLock.lock();
            try {
                return list.size();
            } finally {
                writeLock.unlock();
            }
        }

    }

    public static void main(String[] args) {

        final ReadWriteLockList list = new ReadWriteLockList();
        final Random random = new Random();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    int item = random.nextInt(100);
                    list.addFirst(item);
                    System.out.println(">> add first " + item);

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Adder").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("<< get first " + list.getFirst());

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Taker").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    list.removeFirst();
                    System.out.println("remove first, size " + list.getSize());

                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Remover").start();
    }
}
