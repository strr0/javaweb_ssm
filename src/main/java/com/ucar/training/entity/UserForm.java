package com.ucar.training.entity;

public class UserForm {
    private int id;
    private String name;
    private String sex;
    private int age;
    private String password;
    private String confirmpwd;
    private String[] likes;
    private String tag;
    private int admin;  // 0为普通用户 1为管理员

    public UserForm(){}
    public UserForm(int id, String name, String sex, int age, String password, String confirmpwd, String likes[], String tag, int admin){
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.password = password;
        this.confirmpwd = confirmpwd;
        this.likes = likes;
        this.tag = tag;
        this.admin = admin;
    }
    public UserForm(String name, String sex, int age, String password, String confirmpwd, String[] likes, String tag, int admin){
        this(-1, name, sex, age, password, confirmpwd, likes, tag, admin);
    }

    public String likesToLIKES(){
        String LIKES = "";
        if(likes != null){
            for(String like : likes){
                LIKES += like + ", ";
            }
            LIKES = LIKES.substring(0, LIKES.length() - 2);
        }
        return LIKES;
    }

    public User userFromToUser(){
        String LIKES = likesToLIKES();
        return new User(name, sex, age, password, LIKES, tag, admin);
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
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
    public void setConfirmpwd(String confirmpwd) {
        this.confirmpwd = confirmpwd;
    }
    public String getConfirmpwd() {
        return confirmpwd;
    }
    public void setLikes(String[] likes) {
        this.likes = likes;
    }
    public String[] getLikes() {
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
