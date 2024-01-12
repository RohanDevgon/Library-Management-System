package org.example;

public class book {
    int id;
    String name;
    String author;
    int avail;
    int total;

    public book(int id, String name, String author, int avail, int total) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.avail = avail;
        this.total = total;
    }



    String getname() {
        return name;
    }
}