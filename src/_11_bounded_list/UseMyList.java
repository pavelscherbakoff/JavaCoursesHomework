package _11_bounded_list;

public class UseMyList {

    public static void main(String[] args) throws MyListUnderflowException, MyListOverflowException {

        tryOverflow();
        tryUnderflow();

    }

    private static void tryUnderflow() throws MyListOverflowException, MyListUnderflowException {
        MyList<String> list = new MyList<>(2);

        list.add("one");
        list.add("two");

        list.getLast();
        list.getFirst();
        list.getLast(); // underflow
    }

    private static void tryOverflow() throws MyListOverflowException {
        MyList<String> list = new MyList<>(2);

        list.add("one");
        list.add("two");
        list.add("three"); // overflow
    }

}
