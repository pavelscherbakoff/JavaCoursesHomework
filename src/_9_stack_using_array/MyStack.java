package _9_stack_using_array;

import java.util.Iterator;

public class MyStack<T> implements Iterable<T> {

    private static int INITIAL_CAPACITY = 10;
    private static double CAPACITY_INCREASE = 0.75;
    private static double CAPACITY_DECREASE = 0.5;

    private int size = 0;
    private int capacity = INITIAL_CAPACITY;
    private T[] values = (T[]) new Object[INITIAL_CAPACITY];

    public void push(T value) {
        System.arraycopy(values, 0, values, 1, size);
        values[0] = value;
        size++;

        if (size > capacity * CAPACITY_INCREASE) {
            capacity *= 2;
            updateValuesCapacity();
        }
    }

    public T pop() {
        if (size == 0)
            return null;

        T value = values[0];
        System.arraycopy(values, 1, values, 0, size);
        size--;

        if (size < capacity * CAPACITY_DECREASE) {
            capacity /= 2;
            updateValuesCapacity();
        }

        return value;
    }

    private void updateValuesCapacity() {
        T[] temp = (T[]) new Object[capacity];
        System.arraycopy(values, 0, temp, 0, size);
        values = temp;
    }

    public T top() {
        return values[0];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int capacity() {
        return capacity;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyStackIterator(values);
    }
}