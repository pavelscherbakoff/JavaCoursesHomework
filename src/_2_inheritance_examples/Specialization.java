package _2_inheritance_examples;

public class Specialization {

    static class Food {

        public void eat() {
            System.out.println("Eating " + getClass().getSimpleName());
        }
    }

    static class Meat extends Food {

        @Override
        public void eat() {
            System.out.println("Cooking " + getClass().getSimpleName());
            super.eat();
        }
    }

    static class Pizza extends Food {

        @Override
        public void eat() {
            System.out.println("Ordering " + getClass().getSimpleName());
            super.eat();
        }
    }

    public static void main(String[] args) {
        Food meat = new Meat();
        meat.eat();
        Food pizza = new Pizza();
        pizza.eat();
    }
}
