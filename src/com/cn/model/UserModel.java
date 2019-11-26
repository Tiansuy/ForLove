package com.cn.model;

public class UserModel {
    private String name;//真实姓名
    private String password;//密码
    private int id;//账号
    private String uid;//用户名
    private String info;

    public UserModel() {
    }

    public UserModel(String name, String password, int id, String uid,String info) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.uid = uid;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

}
