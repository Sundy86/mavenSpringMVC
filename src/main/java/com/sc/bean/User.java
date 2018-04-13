package com.sc.bean;

import java.util.Map;

public class User {
    private String name;
    private int age;
    private Map<Object,Object> carmap;

    public Map<Object, Object> getCarmap() {
        return carmap;
    }



    public void setCarmap(Map<Object, Object> carmap) {
        this.carmap = carmap;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", carmap=" + carmap +
                '}';
    }
}
