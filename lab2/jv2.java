package lab2;

import java.util.Random;
import java.util.Scanner;

/**
 * 9121
 * C5 = 1  C = B^T
 * C7 = 0   double
 * C11 = 2   Обчислити суму найбільших елементів кожного стовпця матриці
 **/
public class jv2 {


    public static void main(String[] args) {

        Random rand = new Random();
        int x = 0;
        int y = 0;
        Boolean tr = true;

        //  Визначення кількості рядків
        while (tr) {
            try {
                System.out.println("Введіть кількість рядків (в межах від 1 до 5):");
                Scanner scan = new Scanner(System.in);
                String x_s = scan.nextLine();
                x = Integer.parseInt(x_s);
                tr = false;
            } catch (NumberFormatException e) {
                System.out.println("Введіть число!!!");
                tr = true;
            } finally {
                if (!tr) {
                    if (x > 5 || x < 1) {
                        System.out.println("Ви маєте ввести число від 1 до 5!!!");
                        tr = true;
                    }
                }
            }
        }
        tr = true;

        //  Визначення кількості стовпців
        while (tr) {
            try {
                System.out.println("Введіть кількість стовпців (в межах від 1 до 5):");
                Scanner scan = new Scanner(System.in);
                String x_s = scan.nextLine();
                y = Integer.parseInt(x_s);
                tr = false;
            } catch (NumberFormatException e) {
                System.out.println("Введіть число!!!");
                tr = true;
            } finally {
                if (!tr) {
                    if (y > 5 || y < 1) {
                        System.out.println("Ви маєте ввести число від 1 до 5!!!");
                        tr = true;
                    }
                }
            }
        }
        // Заповнення та вивід на екран матриці
        double[][] B = new double[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                B[i][j] = rand.nextDouble() + (rand.nextInt(20) - 5);
            }
        }
        System.out.println("\n B:");
        for (double[] i : B) {
            System.out.println();
            for (double j : i) {
                System.out.format("[%f]", j);
            }
        }

        double[][] C = new double[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                C[i][j] = B[j][i];
            }
        }
        System.out.println("\n\nC = Транспонована B:");
        for (double[] i : C) {
            System.out.println();
            for (double j : i) {
                System.out.format("[%f]", j);
            }
        }
        // Сума
        double sum = 0;
        for (int i = 0; i < x; i++) {
            double check = 0;
            for (int j = 0; j < y; j++) {
                if (C[j][i] > check) {
                    check = C[j][i];
                }

            }
            sum += check;

        }
        System.out.println("\n\nРезультат додавання найбільших значень кожного стовпця = " + sum);
    }

}
