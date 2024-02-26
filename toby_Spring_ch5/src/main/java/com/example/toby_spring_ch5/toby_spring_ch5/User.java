package com.example.toby_spring_ch5.toby_spring_ch5;

public class User {
    String id;
    String name;
    String passWord;

    public User() {
    }

    public User(String id, String name, String passWord) {
        this.id = id;
        this.name = name;
        this.passWord = passWord;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
