package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите максимум: ");
        int max = scan.nextInt();
        System.out.print("Введите первый делитель: ");
        int divider1 = scan.nextInt();
        System.out.print("Введите второй делитель: ");
        int divider2 = scan.nextInt();

        System.out.println("Сумма чисел, кратных " + divider1 + " и " + divider2 + " меньше " + max + " равна " + getSumOfNaturalMultiples(max, divider1, divider2));
    }

    public static int getSumOfNaturalMultiples(int max, int divider1, int divider2) {
        int sum = 0;
        for (int i = 0; i < max; i++) {
            if (i % divider1 == 0 || i % divider2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
