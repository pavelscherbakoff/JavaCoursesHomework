package _4_linked_list;

public class UseMyList {

    public static void main(String[] args) {

        MyList<String> list = new MyList<>();

        list.add("one");
        list.add("two");
        list.add("three");

        System.out.println(list);
        System.out.println(list.toStringReversed());
        System.out.println(list.getFirst());

        System.out.println(list);
        System.out.println(list.toStringReversed());
        System.out.println(list.getLast());

        System.out.println(list);
        System.out.println(list.toStringReversed());
        System.out.println(list.getLast());
    }

}
