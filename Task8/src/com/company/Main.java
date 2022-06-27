package com.company;

public class Main {

    public static void main(String[] args) {

        Directory directory = new Directory("new", "c:/documents");
        File file1 = new File("file1", 3L, ".txt");
        directory.add(file1);

        System.out.println(file1.getSize());
        System.out.println(file1.getPath());
        System.out.println(directory.getPath());
        System.out.println(directory.getSize());

    }
}
