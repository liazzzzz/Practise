package com.company;

public class TextFile extends File {

    public TextFile(String name, Long size, Directory parentFile) {
        super(name, size, parentFile);
    }

    public String getPath(){
        return parentFile.getPath() + "/" + name + ".txt";
    }

}
