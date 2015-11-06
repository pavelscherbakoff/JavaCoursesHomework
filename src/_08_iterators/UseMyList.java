package _08_iterators;

import java.util.Iterator;

public class UseMyList {

    public static void main(String[] args) {

        MyList<String> list = new MyList<String>() {{
            add("one");
            add("two");
            add("three");
        }};

        Iterator<String> anonymousIterator = list.iterator();
        printListUsingIterator(anonymousIterator);

        Iterator<String> localIterator = list.getLocalIterator();
        printListUsingIterator(localIterator);

        Iterator<String> innerIterator = list.new InnerIterator();
        printListUsingIterator(innerIterator);
    }

    private static void printListUsingIterator(Iterator<String> it) {
        while (it.hasNext()) {
            String item = it.next();
            System.out.println(item);
        }
    }
}
