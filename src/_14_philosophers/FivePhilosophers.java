package _14_philosophers;

public class FivePhilosophers {

    static class Philosopher {

        private final Object leftStick, rightStick;
        long sleepStarted;

        public Philosopher(Object leftStick, Object rightStick) {
            this.leftStick = leftStick;
            this.rightStick = rightStick;
            sleepStarted = System.currentTimeMillis();
        }

        public void eat() {
            synchronized (leftStick) {
                synchronized (rightStick) {
                    long sleepElapsed = System.currentTimeMillis() - sleepStarted;
                    if (sleepElapsed > 20100) // 100ms for sticks switching
                        System.out.println(this + " is dead because not eat during " + sleepElapsed + " ms");
                    System.out.println(this + " started eat");
                    pause(10000);
                    System.out.println(this + " finished eat");
                    sleepStarted = System.currentTimeMillis();
                }
            }
        }
    }

    public static void pause(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Object stick1 = new Object();
        Object stick2 = new Object();
        Object stick3 = new Object();
        Object stick4 = new Object();
        Object stick5 = new Object();

        Philosopher[] philosophers = new Philosopher[5];
        philosophers[0] = new Philosopher(stick1, stick2);
        philosophers[1] =  new Philosopher(stick2, stick3);
        philosophers[2] = new Philosopher(stick3, stick4);
        philosophers[3] = new Philosopher(stick4, stick5);
        philosophers[4] = new Philosopher(stick5, stick1);

        for (Philosopher philosopher : philosophers) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    while (true) {
                        philosopher.eat();
                        pause(20000);
                    }
                }
            }).start();
        }
    }
}