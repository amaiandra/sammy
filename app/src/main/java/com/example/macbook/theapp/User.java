package com.example.macbook.theapp;

import java.io.Serializable;

/**
 * Created by macbook on 10/29/14.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;


    public User() {}

    public String getUsername() {
        return username;
    }
    public String getPassword() {

        return password;
    }
    public void setUsername(String Title) {

        this.username = username;

    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

