package com.company;

import java.util.Scanner;

public class Main {

    public static int sumFibEvenBeforeMax(int max) {
        int a = 1;
        int b = 2;
        int sum = 2;
        int next = a + b;

        while (next < max) {
            if (next % 2 == 0) {
                sum += next;
            }
            a = b;
            b = next;
            next = a + b;
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите max: ");
        int max = scan.nextInt();

        System.out.println("Сумма четных членов Фиббоначи меньше " + max + " равна " + sumFibEvenBeforeMax(max));
    }
}
