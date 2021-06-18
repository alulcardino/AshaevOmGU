package imit;

import java.util.Random;
import java.util.Scanner;

public class Work_with_Arrays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива:  ");
        int n = in.nextInt();
        int[] arr = new int[n];
        Random rnd = new Random();

        // 1
        System.out.println("\n№ 1");
        System.out.println("Рандомизированный массив:");
        for (int i = 0; i < n; i++) {
            arr[i] = -99 + rnd.nextInt(199);
        }
        show(arr);
        System.out.println();

        // 2
        System.out.println("\n№ 2");
        System.out.println("Вводите поочерёдно элементы массива");
        input(arr);
        System.out.println("Введённый массив:");
        show(arr);
        System.out.println();

        // 3
        System.out.println("\n№ 3");
        System.out.println("Сумма элементов массив:");
        System.out.println(sum(arr));

        // 4
        System.out.println("\n№ 4");
        System.out.println("Количество чётных:");
        System.out.println(chetCount(arr));

        // 5
        System.out.println("\n№ 5");
        System.out.print("Введите начальное число отрезка:  ");
        int a = in.nextInt();
        System.out.print("Введите конечное число отрезка:  ");
        int b = in.nextInt();
        System.out.println("Количество чисел, принадлежащих отрезку [" + a + ", " + b + "]:  " + ab(arr, a, b));

        // 6
        System.out.println("\n№ 6");
        if (plus(arr))
            System.out.println("Все элементы в массиве положительные");
        else
            System.out.println("НЕ все элементы в массиве положительные");

        // 7
        System.out.println("\n№ 7");
        rev(arr);
        System.out.println("Реверс:");
        show(arr);
    }

    public static void show(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    public static void input(int[] arr) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
    }

    public static long sum(int[] arr) {
        long sum = 0;
        for (int value : arr) {
            sum += value;
        }
        return sum;
    }

    public static int chetCount(int[] arr) {
        int count = 0;
        for (int value : arr) {
            if (value % 2 == 0)
                count++;
        }
        return count;
    }

    public static int ab(int[] arr, int a, int b) {
        int count = 0;
        if (b < a)
            System.out.println("Пустой отрезок!");
        else {
            for (int value : arr) {
                if (value >= a && value <= b)
                    count++;
            }
        }
        return count;
    }

    public static boolean plus(int[] arr) {
        boolean plus = true;
        for (int i = 0; i < arr.length && plus; i++) {
            if (arr[i] <= 0)
                plus = false;
        }
        return plus;
    }

    public static void rev(int[] arr) {
        int buf = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            buf = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = buf;
        }
    }
}
