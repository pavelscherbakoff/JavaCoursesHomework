package _11_bounded_list;

public class MyList<T> {

    class Node {
        T data;
        Node next;
        Node previous;
    }

    Node first;
    Node last;
    int size, maxSize;

    public MyList(int maxSize) {
        this.maxSize = maxSize;
    }

    public void add(T data) throws MyListOverflowException {
        if (size == maxSize)
            throw new MyListOverflowException(maxSize);
        Node node = new Node();
        node.data = data;
        node.next = null;
        node.previous = null;

        if (null == first)
            first = node;
        else {
            last.next = node;
            node.previous = last;
        }

        last = node;
        size++;
    }

    public T getLast() throws MyListUnderflowException {
        if (size == 0)
            throw new MyListUnderflowException();
        T data = last.data;
        last = last.previous;
        if (size > 1)
            last.next = null;
        size--;
        return data;
    }

    public T getFirst() throws MyListUnderflowException {
        if (size == 0)
            throw new MyListUnderflowException();
        T data = first.data;
        first = first.next;
        if (size > 1)
            first.previous = null;
        size--;
        return data;
    }

    @Override
    public String toString() {

        String s = "[";

        Node current = first;

        while (current != null) {
            s += current.data + " ";
            current = current.next;
        }

        return s + "]";
    }

    public String toStringReversed() {

        String s = "[";

        Node current = last;

        while (current != null) {
            s += current.data + " ";
            current = current.previous;
        }

        return s + "]";
    }
}