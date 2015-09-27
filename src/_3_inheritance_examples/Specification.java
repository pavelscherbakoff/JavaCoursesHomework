package _3_inheritance_examples;

public class Specification {

    static abstract class AbstractPizza {

        abstract void cook();

    }

    static class Pizza extends AbstractPizza {

        @Override
        void cook() {
            System.out.println("Cooking pizza");
        }

    }

    public static void main(String[] args) {
        AbstractPizza pizza = new Pizza();
        pizza.cook();
    }
}