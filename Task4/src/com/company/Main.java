package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите максимально возможное значение: ");
        int maxNumberValue = scan.nextInt();

        System.out.println("Сумма четных членов Фиббоначи меньше " + maxNumberValue + " равна " + getSumOfEvenFibonacciNumbers(maxNumberValue));
    }

    public static int getSumOfEvenFibonacciNumbers(int maxNumberValue) {
        int previous = 1;
        int current = 2;
        int sum = 2;
        int next = previous + current;

        while (next < maxNumberValue) {
            if (next % 2 == 0) {
                sum += next;
            }
            previous = current;
            current = next;
            next = previous + current;
        }
        return sum;
    }
}
