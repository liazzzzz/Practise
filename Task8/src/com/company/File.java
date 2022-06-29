package com.company;

public abstract class File {

    protected Directory parentFile;
    protected String name;
    private Long size;

    public File(String name, Long size, Directory parentFile) {
        this.name = name;
        this.size = size;
        this.parentFile = parentFile;
        parentFile.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Directory getParentFile() {
        return parentFile;
    }

    public void setParentFile(Directory parentFile){
        getParentFile().remove(this);
        this.parentFile = parentFile;
        parentFile.add(this);
    }

    public Long getSize(){
        return size;
    }

    public abstract String getPath();
}
