package _10_stack_using_array;

import java.util.Iterator;

public class UseMyStack {

    public static void main(String[] args) {

        MyStack stack = new MyStack();
        printStack(stack);
        System.out.println("Size = " + stack.size());
        System.out.println("Is empty = " + stack.isEmpty());

        System.out.println("--------------> push");

        stack.push("one");
        printStack(stack);
        System.out.println("Size = " + stack.size());
        System.out.println("Is empty = " + stack.isEmpty());

        stack.push("two");
        printStack(stack);
        System.out.println("Size = " + stack.size());
        System.out.println("Is empty = " + stack.isEmpty());

        stack.push("three");
        printStack(stack);
        System.out.println("Size = " + stack.size());
        System.out.println("Is empty = " + stack.isEmpty());

        System.out.println("--------------> top and pop");

        System.out.println(stack.top());
        System.out.println(stack.pop());
        printStack(stack);
        System.out.println("Size = " + stack.size());
        System.out.println("Is empty = " + stack.isEmpty());

        System.out.println(stack.top());
        System.out.println(stack.pop());
        printStack(stack);
        System.out.println("Size = " + stack.size());
        System.out.println("Is empty = " + stack.isEmpty());

        System.out.println(stack.top());
        System.out.println(stack.pop());
        printStack(stack);
        System.out.println("Size = " + stack.size());
        System.out.println("Is empty = " + stack.isEmpty());

        System.out.println("--------------> top and pop for empty stack");

        System.out.println(stack.top());
        System.out.println(stack.pop());

        System.out.println("--------------> capacity changing");

        System.out.println("Size = " + stack.size());
        System.out.println("Capacity = " + stack.capacity());
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        stack.push("7");
        System.out.println("Size = " + stack.size());
        System.out.println("Capacity = " + stack.capacity());
        stack.push("8");
        System.out.println("Size = " + stack.size());
        System.out.println("Capacity = " + stack.capacity());
        stack.pop();
        System.out.println("Size = " + stack.size());
        System.out.println("Capacity = " + stack.capacity());
        stack.pop();
        System.out.println("Size = " + stack.size());
        System.out.println("Capacity = " + stack.capacity());
        stack.pop();
        System.out.println("Size = " + stack.size());
        System.out.println("Capacity = " + stack.capacity());
        stack.pop();
        System.out.println("Size = " + stack.size());
        System.out.println("Capacity = " + stack.capacity());
    }

    public static void printStack(MyStack stack) {
        Iterator<String> it = stack.iterator();
        String s = "[";
        while (it.hasNext())
            s += it.next() + " ";
        s += "]";
        System.out.println(s);
    }
}