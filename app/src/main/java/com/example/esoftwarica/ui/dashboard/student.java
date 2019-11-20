package com.example.esoftwarica.ui.dashboard;

public class student {
    String age;
    String name;
    String address;
    String gender;

    public student(String age, String name, String address, String gender) {
        this.age = age;
        this.name = name;
        this.address = address;
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }
}
