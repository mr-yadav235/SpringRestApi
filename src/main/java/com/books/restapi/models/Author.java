package com.books.restapi.models;

import java.util.Date;

public class Author {
    private String name;
    private Date dob;

    public Author(){

    }

    public Author(String name,Date dob) {
        this.name = name;
        this.dob = dob;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
