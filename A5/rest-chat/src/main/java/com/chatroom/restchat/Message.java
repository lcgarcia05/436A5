package com.chatroom.restchat;


/**
 * Message model
 */
public class Message {
    private String message;
    private User sender;

    public Message(String message, User sender){
        this.message = message;
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
