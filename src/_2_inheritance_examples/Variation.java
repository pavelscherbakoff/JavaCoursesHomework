package _2_inheritance_examples;

public class Variation {

    static class PhoneLine {

        public void makeCall(String number) {
            System.out.println("Calling " + number);
        }

    }

    static class InternationalPhoneLine extends PhoneLine {

        public void makeCall(String countryCode, String number) {
            System.out.println("Connecting with country " + countryCode);
            makeCall(number);
        }

    }

    public static void main (String[] args) {
        InternationalPhoneLine line = new InternationalPhoneLine();
        line.makeCall("+7", "123-456");
    }
}
