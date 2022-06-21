package com.company;

public class Main {

    public static void main(String[] args) {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum1 += i;
            }
            if (i % 4 == 0 || i % 7 == 0) {
                sum2 += i;
            }
        }
        System.out.println("Сумма чисел, кратных 3 и 5 меньше 1000 равна " + sum1);
        System.out.println("Сумма чисел, кратных 4 и 7 меньше 1000 равна " + sum2);
    }
}
