package com.ucar.training.entity;

public class User {
    private int id;
    private String username;
    private String sex;
    private int age;
    private String password;
    private String likes;
    private String tag;
    private int admin;  // 0为普通用户 1为管理员

    public User(){}
    public User(int id, String username, String sex, int age, String password, String likes, String tag, int admin){
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.age = age;
        this.password = password;
        this.likes = likes;
        this.tag = tag;
        this.admin = admin;
    }
    public User(String username, String sex, int age, String password, String likes, String tag, int admin){
        this(-1, username, sex, age, password, likes, tag, admin);
    }

    public int getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getSex() {
        return sex;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setLikes(String likes) {
        this.likes = likes;
    }
    public String getLikes() {
        return likes;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getTag() {
        return tag;
    }

    public int getAdmin() {
        return admin;
    }
}

