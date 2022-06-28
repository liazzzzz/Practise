package com.company;

public class File {

    public String name;
    public String path;
    public Long size;

    public File(String name, Long size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        int index = getPath().lastIndexOf("/");
        String oldName = getPath().substring(index + 1);
        path = getPath().replace(oldName, name);
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
        int index = getPath().lastIndexOf("/");
        String fileName = getPath().substring(index + 1);
        setName(fileName);
    }

}
