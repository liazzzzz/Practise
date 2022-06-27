package com.company;

import java.util.ArrayList;
import java.util.List;

public class Directory {

    private String name;
    private String location;

    public List<File> listOfFiles = new ArrayList<>(); // список файлов в каталоге
    public List<Directory> listOfDirectories = new ArrayList<>(); // подкаталоги

    public Directory (String name, String location){
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPath(){
        return getLocation() + "/" + getName();
    }

    public void add(File file){
        listOfFiles.add(file);
        file.setLocation(getPath());
    }

    public void add(Directory directory){
        listOfDirectories.add(directory);
    }

    public Long getSize() {
        Long size = 0L;
        for (int i = 0; i < listOfFiles.size(); i++){
            size += listOfFiles.get(i).getSize();
        }
        for (int i = 0; i < listOfDirectories.size(); i++){
            size += listOfDirectories.get(i).getSize();
        }
        return size;
    }

}
