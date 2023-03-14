package com.chatroom.restchat;

import java.util.ArrayList;

/**
 * Chatroom model
 */
public class Chatroom {
    private String name;
    private User creator;
    private ArrayList<User> userList;
    private ArrayList<Message> messageList;

    public Chatroom(String name, User creator){
        this.name = name;
        this.creator = creator;
        userList = new ArrayList<>();
        messageList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addUser(User newUser){
        userList.add(newUser);
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setArrayList(ArrayList<User> arrayList) {
        this.userList = arrayList;
    }

    public ArrayList<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(ArrayList<Message> messageList) {
        this.messageList = messageList;
    }

    public void removeUser(User user){
        this.userList.remove(user);
    }

    public boolean contains(User user){
        return userList.contains(user);
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public void addMessageHistory(Message mes){
        messageList.add(mes);
    }
}
