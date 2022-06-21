package com.company;

public class Main {

    public static void main(String[] args) {

        int max1 = 100;
        int max2 = 4000000;

        int a = 1;
        int b = 2;
        int sum1 = 2;
        int sum2 = 2;
        int next = a + b;

        while (next < max2) {
            if (next % 2 == 0) {
                if (next < max1) {
                    sum1 += next;
                }
                sum2 += next;
            }
            a = b;
            b = next;
            next = a + b;
        }
        System.out.println("Сумма четных членов Фиббоначи меньше 100 равна " + sum1);
        System.out.println("Сумма четных членов Фиббоначи меньше 4000000 равна " + sum2);
    }
}
