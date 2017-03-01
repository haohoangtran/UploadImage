package com.example.haohoang.camera.models;

/**
 * Created by haohoang on 2/28/17.
 */

public class Student{
    private String id;
    private String name;
    private String className;
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Student(String id, String name, String className, String url) {

        this.id = id;
        this.name = name;
        this.className = className;
        this.url = url;
    }
}
