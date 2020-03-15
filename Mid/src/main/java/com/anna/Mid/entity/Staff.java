package com.anna.Mid.entity;

public class Staff {
    private String id;
    private String name;
    private int age;
    private Position position;
    private float salary;

    public Staff(String id, String name, int age, Position position, float salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;

        this.salary = salary;
    }

    public Staff(String name, int age, Position position, float salary) {
        this.name = name;
        this.age = age;
        this.position = position;

        this.salary = salary;
    }

    public Staff() {
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


}
