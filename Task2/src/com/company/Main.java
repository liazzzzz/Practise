package com.company;

public class Main {

    public static void main(String[] args) {
        int n = 4000000;

        int a = 1;
        int b = 2;
        int sum = 2;
        int next = a + b;

        while (next < n){
            if (next % 2 == 0){
                sum += next;
            }
            a = b;
            b = next;
            next = a + b;
        }
        System.out.println(sum);
    }
}
