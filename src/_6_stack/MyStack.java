package _6_stack;

public class MyStack<T> {

    class Node {
        T data;
        Node next;
    }

    Node top;

    public void push(T data) {
        Node node = new Node();
        node.data = data;
        node.next = top;
        top = node;
    }

    public T pop() {
        Node node = top;
        top = node.next;
        return node.data;
    }

    @Override
    public String toString() {

        String s = "[";

        Node current = top;

        while (current != null) {
            s += current.data + " ";
            current = current.next;
        }

        return s + "]";
    }
}