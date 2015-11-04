package _11_bounded_list;

public class MyListUnderflowException extends Exception {

    public MyListUnderflowException() {
        super("List is empty");
    }
}
