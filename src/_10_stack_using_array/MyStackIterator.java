package _10_stack_using_array;

import java.util.Iterator;

public class MyStackIterator implements Iterator<String> {

    String[] stack;
    int current;

    public MyStackIterator(String[] stack) {
        this.stack = stack;
        current = 0;
    }

    @Override
    public boolean hasNext() {
        return stack[current] != null;
    }

    @Override
    public String next() {
        String value = stack[current];
        current++;
        return value;
    }
}