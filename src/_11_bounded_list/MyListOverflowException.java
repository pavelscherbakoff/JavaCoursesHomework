package _11_bounded_list;

public class MyListOverflowException extends Exception {

    public MyListOverflowException(int size) {
        super("List is overflowed. Max size = " + size);
    }
}