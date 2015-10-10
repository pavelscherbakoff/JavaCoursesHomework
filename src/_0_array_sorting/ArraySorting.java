package _0_array_sorting;

import java.util.Random;

public class ArraySorting {

    public static void main(String args[]) {
        Integer[] array = new Integer[10];
        fill(array);
        print("Before sorting", array);
        sort(array);
        print("After sorting", array);
    }

    private static Integer[] fill(Integer[] array) {
        Random random = new Random();
        for (int index = 0; index < array.length; index++)
            array[index] = random.nextInt(100);
        return array;
    }

    private static Integer[] sort(Integer[] array) {
        for (int index = 0; index < array.length; index++)
            for (int innerIndex = index; innerIndex < array.length; innerIndex++)
                if (array[innerIndex] < array[index]) {
                    int temp = array[innerIndex];
                    array[innerIndex] = array[index];
                    array[index] = temp;
                }
        return array;
    }

    private static void print(String message, Integer[] array) {
        System.out.print(message + ": ");
        String arrayStr = "[";
        for (int index = 0; index < array.length; index++) {
            arrayStr += array[index];
            if (index < array.length - 1)
                arrayStr += ", ";
        }
        arrayStr += "]";
        System.out.println(arrayStr);
    }
}