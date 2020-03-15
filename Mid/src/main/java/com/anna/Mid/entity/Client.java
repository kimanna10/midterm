package com.anna.Mid.entity;

public class Client {
    private String id;
    private String name;
    private int age;
    private Group group;


    public Client(String id, String name, int age, Group group, float salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public Client(String name, int age, Group group, float salary) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public Client() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

}
