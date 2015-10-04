package _10_stack_using_array;

import java.util.Iterator;

public class MyStack implements Iterable {

    private static int INITIAL_CAPACITY = 10;
    private static double CAPACITY_INCREASE = 0.75;
    private static double CAPACITY_DECREASE = 0.5;

    private int size = 0;
    private int capacity = INITIAL_CAPACITY;
    private String[] values = new String[INITIAL_CAPACITY];

    public void push(String value) {
        System.arraycopy(values, 0, values, 1, size);
        values[0] = value;
        size++;

        if (size > capacity * CAPACITY_INCREASE) {
            capacity *= 2;
            updateValuesCapacity();
        }
    }

    public String pop() {
        if (size == 0)
            return null;

        String value = values[0];
        System.arraycopy(values, 1, values, 0, size);
        size--;

        if (size < capacity * CAPACITY_DECREASE) {
            capacity /= 2;
            updateValuesCapacity();
        }

        return value;
    }

    private void updateValuesCapacity() {
        String[] temp = new String[capacity];
        System.arraycopy(values, 0, temp, 0, size);
        values = temp;
    }

    public String top() {
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
    public Iterator<String> iterator() {
        return new MyStackIterator(values);
    }
}