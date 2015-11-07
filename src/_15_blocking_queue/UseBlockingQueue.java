package _15_blocking_queue;

public class UseBlockingQueue {

    public static void main(String[] args) {

        final BlockingQueue<String> queue = new BlockingQueue<>(3);

        new Thread(new Runnable() {
            @Override
            public void run() {
                queue.put("one");
                System.out.println("put");
                pause(2000);
                queue.put("two");
                System.out.println("put");
                pause(2000);
                queue.put("three");
                System.out.println("put");
                pause(2000);
                queue.put("four");
                System.out.println("put");
                pause(2000);
                queue.put("five");
                System.out.println("put");
            }
        }).start();

        pause(10000);

        while(true) {
            pause(3000);
            System.out.println(queue.take());
        }
    }

    public static void pause(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}