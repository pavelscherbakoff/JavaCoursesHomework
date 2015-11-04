package _12_deep_copy;

import java.io.*;

public class Copy {

    public static class A implements Serializable {
        B b = new B();
        int i = 0;
    }

    public static class B implements Serializable {
        C c = new C();
        int j = 0;
    }

    public static class C implements Serializable {
        int k = 0;
    }

    public static class D {
        int f = 0;
    }

    public static Object deepCopy(Object object) {
        Object copy;

        if (object instanceof Serializable) {
            try {

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(object);

                byte[] byteArray = baos.toByteArray();

                ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
                ObjectInputStream ois = new ObjectInputStream(bais);
                copy = ois.readObject();

            } catch (IOException | ClassNotFoundException e) {
                return null;
            }
            return copy;
        } else
            return null;
    }

    public static void main(String[] args) {
        A a = new A();
        D d = new D();

        A copyA = (A) deepCopy(a);
        D copyD = (D) deepCopy(d);

        System.out.println(copyA); // copied
        System.out.println(copyD); // not copied
    }
}
