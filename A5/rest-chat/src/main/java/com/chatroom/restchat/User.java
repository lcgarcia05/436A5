package com.chatroom.restchat;

import java.util.ArrayList;

/**
 * User model
 */
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
