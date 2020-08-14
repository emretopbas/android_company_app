package com.example.project;

import java.io.Serializable;

public class Message implements Serializable {
    public String name, email, phonenumber, message;

    public Message() {
    }

    public Message(String name, String email, String phonenumber, String message) {
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
        this.message = message;
    }
}
