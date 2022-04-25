package com.example.appregistro;

public class Student {
    private String name;
    private String lastName;
    private String email;
    private int phone;
    private int score;

    public Student(String name, String lastName, String email, int phone, int score) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.score = score;
    }
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public int getPhone() {
        return phone;
    }
    public int getScore() {
        return score;
    }
}
