package _02_inheritance_examples;

public class Restriction {

    static class Phone extends SmartPhone {

        @Override
        public void makeCall() {
            System.out.println("Making call using buttons");
        }

        @Override
        public void sendSms() {
            System.out.println("Sending sms using buttons");
        }

        @Override
        public void makePhoto() {
            throw new UnsupportedOperationException();
        }
    }

    static class SmartPhone {

        public void makeCall() {
            System.out.println("Making call using touchscreen");
        }
        public void sendSms() {
            System.out.println("Sending sms using touchscreen");
        }
        public void makePhoto() {
            System.out.println("Making photo");
        }
    }

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.makeCall();
        phone.sendSms();
        phone.makePhoto();
    }
}
