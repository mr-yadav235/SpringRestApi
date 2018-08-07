package com.books.restapi.models;

public class Publisher {

    private String name;
    private Address address;

    public Publisher(){

    }
    public Publisher(String name,Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
