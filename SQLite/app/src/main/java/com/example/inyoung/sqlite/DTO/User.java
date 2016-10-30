package com.example.inyoung.sqlite.DTO;

/**
 * Created by Inyoung on 2016-06-04.
 */
public class User {
    public String id;
    public String pw;
    public String name;
    public int age;
    public String addr;

    public User(){

    }
    public User(String id, String pw, String name, int age, String addr){
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.age = age;
        this.addr = addr;
    }
}
