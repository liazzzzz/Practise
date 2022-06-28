package com.company;

import java.util.ArrayList;

public class Directory extends File {

    public ArrayList<File> filesAndDirectories = new ArrayList<>();

    public Directory(String name, String path) {
        super(name, 0L);
        this.path = path;
    }

    public void add(File file) {
        if (file.getPath() == null) {
            filesAndDirectories.add(file);
            file.path = path + "/" + file.name;
        } else {
            System.out.println("Скопируйте файл, чтобы добавить");
//            File file_copy = new File(file.name, file.size, file.type);
//            add(file_copy);
        }
    }

    public void update() {
        for (int i = 0; i < filesAndDirectories.size(); i++) {
            if (!filesAndDirectories.get(i).getPath().contains(path)) {
                filesAndDirectories.remove(filesAndDirectories.get(i));
                // добоавить файл в новый каталог
            }
        }
    }

    @Override
    public Long getSize() {
        Long size = 0L;
        for (int i = 0; i < filesAndDirectories.size(); i++) {
            size += filesAndDirectories.get(i).getSize();
        }
        return size;
    }

}
