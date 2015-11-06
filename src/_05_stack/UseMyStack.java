package _05_stack;

public class UseMyStack {

    public static void main(String[] args) {

        MyStack<String> list = new MyStack<>();

        list.push("First");
        list.push("Second");
        list.push("Third");
        list.push("Fourth");

        System.out.println(list);
        System.out.println(list.pop() + " is out");
        System.out.println(list);
        System.out.println(list.pop() + " is out");
        System.out.println(list);
        System.out.println(list.pop() + " is out");
        System.out.println(list);
        System.out.println(list.pop() + " is out");
        System.out.println(list);
    }
}
