package com.chatroom.restchat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Main controller for the service, handles all the hit endpoints and respond with the correct operations.
 */
@RestController
public class ChatController {

    @Autowired
    ChatService service;

    @PostMapping("/createUser")
    public String createUser(@RequestParam(value = "userName") String name){
        return service.createUser(name);
    }

    @GetMapping("/getConnectedUsers")
    public ArrayList<User> getConnectedUser(){
        return service.getConnectedUsers();
    }

    @PostMapping("/createChatroom")
    public String createChatroom(@RequestParam(value = "roomName") String name, @RequestParam(value ="userName") String creator){
        return service.createRoom(name, creator);
    }

    @GetMapping("/getChatrooms")
    public List<Chatroom> getRooms(){
        return service.getChatrooms();
    }

    @PostMapping("/message")
    public String sendMessage(@RequestParam (value = "message") String message, @RequestParam (value ="userName") String name){
        return service.sendMessage(message, name);
    }

    @GetMapping("/getMessages")
    public List<Message> getMessages(){
        return service.getMessages();
    }

    @GetMapping("/getRoomMessage")
    public List<Message> getRoomMessage(@RequestParam (value = "roomName") String roomName){
        return service.getRoomMessage(roomName);
    }

    @PostMapping("/join")
    public String join(@RequestParam (value = "room") String roomName, @RequestParam (value ="userName") String userName){
        return service.joinRoom(roomName, userName);
    }

    @PostMapping("/leave")
    public String leave(@RequestParam (value ="user") String name){
        return service.leaveRoom(name);
    }

    @PostMapping("/quit")
    public String quit(@RequestParam (value = "user") String name){
        return service.removeUser(name);
    }
}
