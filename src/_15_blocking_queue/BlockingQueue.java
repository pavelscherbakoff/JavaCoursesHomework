package _15_blocking_queue;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {

    private Queue<T> queue = new LinkedList<>();
    private final static Object notEmpty = new Object();
    private final static Object notFull = new Object();
    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public T take() {
        synchronized (notEmpty) {
            while (queue.isEmpty()) {
                try {
                    notEmpty.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (notFull) {
                notFull.notify();
            }
            return queue.poll();
        }
    }

    public void put(T item) {
        synchronized (notFull) {
            while (queue.size() == capacity) {
                try {
                    notFull.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.offer(item);
            synchronized (notEmpty) {
                notEmpty.notify();
            }
        }
    }
}