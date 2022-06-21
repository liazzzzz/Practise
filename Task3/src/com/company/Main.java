package com.company;

import java.util.Scanner;

public class Main {

    public static int multi(int max, int k1, int k2) {
        int sum = 0;
        for (int i = 0; i < max; i++) {
            if (i % k1 == 0 || i % k2 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите max: ");
        int max = scan.nextInt();
        System.out.print("Введите первый делитель: ");
        int k1 = scan.nextInt();
        System.out.print("Введите второй делитель: ");
        int k2 = scan.nextInt();

        System.out.println("Сумма чисел, кратных " + k1 + " и " + k2 + " меньше " + max + " равна " + multi(max, k1, k2));
    }
}
