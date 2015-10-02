package _5_linked_list;

public class MyList<T> {

    class Node {
        T data;
        Node next;
    }

    Node first;
    Node last;

    public void add(T data) {
        Node node = new Node();
        node.data = data;
        node.next = null;

        if (null == first)
            first = node;
        else
            last.next = node;

        last = node;
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
}