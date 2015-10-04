package _10_stack_using_array;

import java.util.Iterator;

public class MyStackIterator<T> implements Iterator<T> {

    T[] stack;
    int current;

    public MyStackIterator(T[] stack) {
        this.stack = stack;
        current = 0;
    }

    @Override
    public boolean hasNext() {
        return stack[current] != null;
    }

    @Override
    public T next() {
        T value = stack[current];
        current++;
        return value;
    }
}