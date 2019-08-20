package com.ucar.training.entity;

public class UserForm {
    private int id;
    private String username;
    private String sex;
    private int age;
    private String password;
    private String confirmpwd;
    private String[] likes;
    private String tag;
    private String usertype;

    public UserForm(){}
    public UserForm(int id, String username, String sex, int age, String password, String confirmpwd, String likes[], String tag, String usertype){
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.age = age;
        this.password = password;
        this.confirmpwd = confirmpwd;
        this.likes = likes;
        this.tag = tag;
        this.usertype = usertype;
    }
    public UserForm(String username, String sex, int age, String password, String confirmpwd, String[] likes, String tag, String usertype){
        this(-1, username, sex, age, password, confirmpwd, likes, tag, usertype);
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
        int admin = 0;
        if(usertype.equals("admin")){
            admin = 1;
        }
        return new User(username, sex, age, password, LIKES, tag, admin);
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

    public String getUsertype() {
        return usertype;
    }
}
