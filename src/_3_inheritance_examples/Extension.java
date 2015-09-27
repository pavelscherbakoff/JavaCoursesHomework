package _3_inheritance_examples;

public class Extension {

    static class Phone {

    }

    static class SmartPhone extends Phone {

        public void makePhoto() {
            System.out.println("Making photo");
        }
    }

    public static void main(String[] args) {
        SmartPhone smartPhone = new SmartPhone();
        smartPhone.makePhoto();
    }
}
