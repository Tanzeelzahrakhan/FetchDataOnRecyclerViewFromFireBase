package com.example.firebasefirstlectureinsertfetchdata;

public class ModelClass {
    String Name,Email,Password,Dept;
    public ModelClass(String name, String email, String password, String dept) {
        Name = name;
        Email = email;
        Password = password;
        Dept = dept;
    }
    public ModelClass() {
    }
    public String getName() {
        return Name;
    }
    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }
    public String getDept() {
        return Dept;
    }
}
