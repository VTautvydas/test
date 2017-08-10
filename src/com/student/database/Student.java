package com.student.database;

public class Student {

    private int id;
    private String name, surname, group_id;

    public Student() {
    }

    public Student(int id, String name, String surname, String group_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.group_id = group_id;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return this.surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

}
