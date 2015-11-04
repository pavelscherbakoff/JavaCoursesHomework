package _13_matrix_with_threads;

import java.util.Random;

public class HomeWork {

    static class Timer {
        static long started, elapsed;
        static void start() {
            started = System.currentTimeMillis();
        }
        static long stop() {
            elapsed = System.currentTimeMillis() - started;
            return elapsed;
        }
    }

    public static void main(String[] args) {
        Timer.start();
        double[][] matrix = generate();
        System.out.println("Generation = " + Timer.stop() + " ms");

        Timer.start();
        matrix = generateWithThreads();
        System.out.println("Generation with threads = " + Timer.stop() + " ms");

        Timer.start();
        process(matrix);
        System.out.println("Processing = " + Timer.stop() + " ms");
    }

    private static void process(double[][] matrix) {

        Thread[] threads = new Thread[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            final double[] row = matrix[i];
            threads[i] = new Thread() {
                @Override
                public void run() {
                    processRow(row);
                };
            };
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void processRow(double[] ds) {
        for (int i = 0; i < ds.length; i++) {
            Math.pow(ds[i], ds[i]);
        }
    }

    private static double[][] generate() {

        Random random = new Random();

        double[][] matrix = new double[10][4_000_000];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextDouble();
            }
        }

        return matrix;
    }

    private static double[][] generateWithThreads() {

        Random random = new Random();

        double[][] matrix = new double[10][4_000_000];
        Thread[] threads = new Thread[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            final int finalI = i;
            threads[i] = new Thread() {

                @Override
                public void run() {
                    for (int j = 0; j < matrix[finalI].length; j++) {
                        matrix[finalI][j] = random.nextDouble();
                    }
                }
            };
            threads[i].run();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return matrix;
    }


}