package org.example;

import java.util.ArrayList;

public class member {
    Long phone;
    int age;
    String name;
    int memberId;
    ArrayList<book> myBooks= new ArrayList<book>();


    public member(Long phone, int age, String name, int memberId, ArrayList<book> myBooks) {
        this.phone = phone;
        this.age = age;
        this.name = name;
        this.memberId = memberId;
        this.myBooks = myBooks;
    }


}