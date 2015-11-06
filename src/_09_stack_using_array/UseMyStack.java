package _09_stack_using_array;

import java.util.Iterator;

public class UseMyStack {

    public static void main(String[] args) {

        MyStack<String> stack = new MyStack<>();

        System.out.println("----------> Initial stack");
        printStackWithParams(stack);

        System.out.println("----------> Push one");
        stack.push("one");
        printStackWithParams(stack);

        System.out.println("----------> Push two");
        stack.push("two");
        printStackWithParams(stack);

        System.out.println("----------> Push three");
        stack.push("three");
        printStackWithParams(stack);

        System.out.println("----------> Top and pop");
        System.out.println(stack.top());
        System.out.println(stack.pop());
        printStackWithParams(stack);

        System.out.println("----------> Top and pop");
        System.out.println(stack.top());
        System.out.println(stack.pop());
        printStackWithParams(stack);

        System.out.println("----------> Top and pop");
        System.out.println(stack.top());
        System.out.println(stack.pop());
        printStackWithParams(stack);

        System.out.println("----------> Top and pop");
        System.out.println(stack.top());
        System.out.println(stack.pop());

        System.out.println("----------> Push one");
        stack.push("one");
        printStackWithParams(stack);

        System.out.println("----------> Push two");
        stack.push("two");
        printStackWithParams(stack);
    }

    private static void printStackWithParams(MyStack stack) {
        Iterator it = stack.iterator();
        String stringStack = "[";
        while (it.hasNext())
            stringStack += it.next() + " ";
        stringStack += "]";
        System.out.println(stringStack);
        System.out.println("Capacity = " + stack.capacity());
        System.out.println("Size = " + stack.size());
        System.out.println("Is empty = " + stack.isEmpty());
    }
}