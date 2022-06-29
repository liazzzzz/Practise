package com.company;

import java.util.ArrayList;

public class Directory extends File {

    private ArrayList<File> filesAndDirectories = new ArrayList<>();

    public Directory(String name, Directory parentFile) {
        super(name, 0L, parentFile);
        parentFile.add(this);
    }

    public void add(File file){
        filesAndDirectories.add(file);
    }

    public void remove(File file){
        filesAndDirectories.remove(file);
    }

    @Override
    public Long getSize() {
        Long size = 0L;
        for (int i = 0; i < filesAndDirectories.size(); i++){
            size += filesAndDirectories.get(i).getSize();
        }
        return size;
    }

    public String getPath(){
        return parentFile.getPath() + "/" + getName();
    }

}
