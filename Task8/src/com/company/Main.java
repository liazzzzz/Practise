package com.company;

public class Main {

    public static void main(String[] args) {

        Directory directory = new Directory("new", "c:/documents/new");
        File file1 = new File("file1.txt", 1L);
        directory.add(file1);

        file1.setPath("c:/another/dog.txt");
        directory.update();

        System.out.println(file1.getSize());
        System.out.println(file1.getPath());
        System.out.println(directory.getPath());
        System.out.println(directory.getSize());

    }
}
