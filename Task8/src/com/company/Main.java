package com.company;

public class Main {

    public static void main(String[] args) {

        Directory root = new Directory("c:", null); // корневой каталог

        Directory directory = new Directory("catalog1", root);
        TextFile textFile = new TextFile("cat", 1L, directory);

        textFile.getPath();
        textFile.getSize();
        directory.getPath();
        directory.getSize();

    }
}
