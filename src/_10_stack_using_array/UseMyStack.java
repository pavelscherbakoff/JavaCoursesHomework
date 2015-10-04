package _10_stack_using_array;

import java.util.Iterator;

public class UseMyStack {

    public static void main(String[] args) {

        MyStack stack = new MyStack();

        System.out.println("----------> Initial stack");
        printStack(stack);
        printStackParams(stack);

        System.out.println("----------> Push one");
        stack.push("one");
        printStack(stack);
        printStackParams(stack);

        System.out.println("----------> Push two");
        stack.push("two");
        printStack(stack);
        printStackParams(stack);

        System.out.println("----------> Push three");
        stack.push("three");
        printStack(stack);
        printStackParams(stack);

        System.out.println("----------> Top and pop");
        System.out.println(stack.top());
        System.out.println(stack.pop());
        printStack(stack);
        printStackParams(stack);

        System.out.println("----------> Top and pop");
        System.out.println(stack.top());
        System.out.println(stack.pop());
        printStack(stack);
        printStackParams(stack);

        System.out.println("----------> Top and pop");
        System.out.println(stack.top());
        System.out.println(stack.pop());
        printStack(stack);
        printStackParams(stack);

        System.out.println("----------> Top and pop");
        System.out.println(stack.top());
        System.out.println(stack.pop());

        System.out.println("----------> Push one");
        stack.push("one");
        printStack(stack);
        printStackParams(stack);

        System.out.println("----------> Push two");
        stack.push("two");
        printStack(stack);
        printStackParams(stack);
    }

    private static void printStack(MyStack stack) {
        Iterator<String> it = stack.iterator();
        String s = "[";
        while (it.hasNext())
            s += it.next() + " ";
        s += "]";
        System.out.println(s);
    }

    private static void printStackParams(MyStack stack) {
        System.out.println("Capacity = " + stack.capacity());
        System.out.println("Size = " + stack.size());
        System.out.println("Is empty = " + stack.isEmpty());
    }
}