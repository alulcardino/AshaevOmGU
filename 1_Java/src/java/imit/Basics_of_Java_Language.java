package imit;

import java.util.Scanner;

public class Basics_of_Java_Language {

    public static void main1(String[] args) {
        System.out.println("Hello World!");
    }

    public static void main2(String[] args) {
        System.out.println("Введите 3 вещественных числа:");
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        System.out.println("Произведение:  " + a * b * c);
        System.out.println("Среднее арифметическое:  " + (a + b + c) / 3);
        System.out.println("Числа в порядке возрастания:");
        // Без использования доп.буфера
        if (a <= b && b <= c)
            System.out.println(a + " " + b + " " + c);
        else if (a <= c && c <= b)
            System.out.println(a + " " + c + " " + b);
        else if (b <= a && a <= c)
            System.out.println(b + " " + a + " " + c);
        else if (b <= c && c <= a)
            System.out.println(b + " " + c + " " + a);
        else if (c <= a && a <= b)
            System.out.println(c + " " + a + " " + b);
        else if (c <= b && b <= a)
            System.out.println(c + " " + b + " " + a);
        System.out.println();
        // С использованием доп.буфера
        double buf;
        if (a > b) {
            buf = b;
            b = a;
            a = buf;
        }
        if (b > c) {
            buf = c;
            c = b;
            b = buf;
        }
        if (a > b) {
            buf = b;
            b = a;
            a = buf;
        }
        System.out.println(a + " " + b + " " + c);
    }

    public static void main3(String[] args) {
        System.out.println("Введите 3 целых числа:");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        System.out.println("Произведение:  " + a * b * c);
        System.out.println("Среднее арифметическое:  " + (double) (a + b + c) / 3);
        System.out.println("Числа в порядке возрастания:");
        // Без использования доп.буфера
        if (a <= b && b <= c)
            System.out.println(a + " " + b + " " + c);
        else if (a <= c && c <= b)
            System.out.println(a + " " + c + " " + b);
        else if (b <= a && a <= c)
            System.out.println(b + " " + a + " " + c);
        else if (b <= c)
            System.out.println(b + " " + c + " " + a);
        else if (a <= b)
            System.out.println(c + " " + a + " " + b);
        else
            System.out.println(c + " " + b + " " + a);
        System.out.println();
        // С использованием доп.буфера
        int buf;
        if (a > b) {
            buf = b;
            b = a;
            a = buf;
        }
        if (b > c) {
            buf = c;
            c = b;
            b = buf;
        }
        if (a > b) {
            buf = b;
            b = a;
            a = buf;
        }
        System.out.println(a + "\n" + b + "\n" + c);
    }

    public static void main4(String[] args) {
        System.out.println("Введите 3 вещественных коэффициента:");
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        if (a == 0)
            System.out.println("Это не квадратное уравнение!");
        else {
            double D = b * b - 4 * a * c;
            if (D < 0)
                System.out.println("Корней нет! Дискриминант меньше 0");
            else {
                double r1 = (-b + Math.sqrt(D)) / (2 * a);
                double r2 = (-b - Math.sqrt(D)) / (2 * a);
                if (Math.abs(r1 - r2) < 1E-12)
                    System.out.println("Корень уравнения:  " + r1);
                else
                    System.out.println("Корни уравнения: \n" + r1 + "\n" + r2);
            }
        }
    }

    public static void main5(String[] args) {

        // 0 0 -0,1
        // 0 1 -0,1

        Scanner in = new Scanner(System.in);
        System.out.println("Введите нижнюю границу:  ");
        double inf = in.nextDouble();
        System.out.println("Введите верхнюю границу:  ");
        double sup = in.nextDouble();
        if (sup < inf)
            System.out.println("Верхняя граница не может быть меньше нижней!");
        else {
            System.out.println("Введите шаг табуляции:  ");
            double h = in.nextDouble();
            if (h == 0) {
                System.out.println("Шаг табуляции не может быть нулевым!");
            } else if (h < 0) {
                System.out.println("Шаг табуляции не может быть отрицательным!");
            } else {
                System.out.println("Табулияция функции sin(x)");
                for (double x = inf; x <= sup; x += h) {
                    System.out.print(x + ":\t");
                    System.out.println(Math.sin(x));
                }
            }
        }
    }

    public static void main(String[] args) {

        solveLU(0, 0, 0, 0, 0, 0);
        System.out.println();
        solveLU(0, 0, 1, 0, 0, 0);
        solveLU(0, 0, 0, 0, 0, 1);
        solveLU(1, 2, 3, 0, 0, 1);
        solveLU(1, 0, 3, 2, 0, 7);
        solveLU(0, 2, 3, 0, 5, 7);
        solveLU(1, 2, 3, 2, 4, 8);
        System.out.println();
        solveLU(1, 2, 3, 0, 0, 0);
        solveLU(1, 2, 3, 2, 4, 6);
        solveLU(0, 2, 3, 0, 4, 6);
        solveLU(1, 0, 3, 2, 0, 6);
        System.out.println();
        solveLU(1, 2, 3, 4, 5, 6);
    }

    private static void solveLU(double a1, double b1, double c1, double a2, double b2, double c2) {
        // Метод Крамера
        if ((a1 == 0 && b1 == 0 && c1 != 0) || (a2 == 0 && b2 == 0 && c2 != 0))
            System.out.println("Система не имеет решений!");
        else {
            double det = a1 * b2 - a2 * b1;
            double det1 = c1 * b2 - c2 * b1;
            double det2 = a1 * c2 - a2 * c1;
            if (det != 0) {
                System.out.println("x1:  " + det1 / det);
                System.out.println("x2:  " + det2 / det);
            } else if (Double.compare(det1, 0) == 0 && Double.compare(det2, 0) == 0) {
                System.out.println("Система имеет бесконечное множество решений!");
            } else {
                System.out.println("Система не имеет решений!");
            }
        }
    }

    public static void main7(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите x:  ");
        double x = in.nextDouble();
        System.out.println("Введите точность:  ");
        double eps = in.nextDouble();
        double res = 1; // Первая итерация (точнее x^0/0! = 1)
        double res2 = eps + 2; // Для того, чтобы зайти в цикл (разность > eps)
        long fn = 1; // Начальное значение факториала
        double powX = x; // x в 1-й степени
        for (int n = 1; Math.abs(res - res2) > eps; n++) {
            res2 = res; // Первый результат становится вторым
            fn *= n; // Увеличиваем факториал
            res += powX / fn; // Считаем новый результат
            powX *= x; // Затем увеличиваем степень
        }
        System.out.println("Результат:  " + res);
        System.out.println("Результат:  " + Math.exp(x));
    }
}