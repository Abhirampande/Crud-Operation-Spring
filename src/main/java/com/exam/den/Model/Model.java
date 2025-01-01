package com.exam.den.Model;

import jakarta.persistence.*;

@Entity
public class Model {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column
    private String name;
    @Column
    private int age;

    public Model(){

    }
    public Model(String name, int age){
        super();
        this.name = name;
        this.age = age;
    }

    public int getId(){
        return Id;
    }

    public void setId(int id){
        this.Id = Id;
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
}
