package com.djxc.study.web.entity;

public class User {
    private int id;
    private String name;
    private String passwd;
    private int authority;

    public User() {
    }

    public User(String name, String passwd){
        this.name = name;
        this.passwd = passwd;
    }

    public User(int id, String name, String passwd, int authority) {
        this.id = id;
        this.name = name;
        this.passwd = passwd;
        this.authority = authority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }
}
