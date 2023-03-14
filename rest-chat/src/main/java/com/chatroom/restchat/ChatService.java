package com.chatroom.restchat;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * The class that handles all received requests from the client
 */
@Service
public class ChatService {

    private List<Chatroom> chatrooms;
    private final ArrayList<User> connectedUsers;
    private List<Message> messages;

    public ChatService(){
        chatrooms = new ArrayList<>();
        connectedUsers = new ArrayList<>();
        messages = new ArrayList<>();
        connectedUsers.add(new User("testuser1"));
    }

    /**
     * Creates the user
     * @param name - user name
     * @return
     */
    public String createUser(String name){
        connectedUsers.add(new User(name));
        return "User created";
    }

    /**
     * Creates the chatroom from the users input
     * @param name - chatroom name
     * @param creator - user that created the room
     * @return
     */
    public String createRoom(String name, String creator){
        User user = findUser(creator);
        if (user == null){
            User u = new User(creator);
            Chatroom c = new Chatroom(name, u);
            c.addUser(u);
            chatrooms.add(c);
            return "Room created";
        }
        Chatroom c = new Chatroom(name, user);
        c.addUser(user);
        chatrooms.add(c);
        return "Room created";
    }

    /**
     * Retrieves the list of chatrooms available
     * @return - list of chatrooms
     */
    public List<Chatroom> getChatrooms(){
        return this.chatrooms;
    }

    /**
     * Makes a user to join a room
     * @param roomName - room to join
     * @param userName - user to join
     * @return
     */
    public String joinRoom(String roomName, String userName){
        try {
        Chatroom room = findChatroom(roomName);
        User user = findUser(userName);
        room.addUser(user);
        return "User" + userName + " has joined the room: " + roomName;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Cannot find the given user";
        }
    }

    /**
     * Makes a user to leave a room
     * @param name - user to leave the room
     * @return
     */
    public String leaveRoom(String name){
        User found = findUser(name);
        for (Chatroom cr : chatrooms){
            if (cr.contains(found)){
                cr.removeUser(found);
            }
        }
        return "User " + found.getName() + " has left the room.";
    }

    public ArrayList<User> getConnectedUsers(){
        return this.connectedUsers;
    }

    public List<Message> getMessages(){
        return this.messages;
    }

    /**
     *
     * @param message - message to send to other users
     * @param name - user that sent the message
     * @return a confirmation
     */
    public String sendMessage(String message, String name){
        User found = findUser(name);
        Message mes = new Message(message, found);
        for (Chatroom cr : chatrooms){
            if (cr.contains(found)){
                cr.addMessageHistory(mes);
            }
        }
        return "Message sent";
    }

    public void setChatrooms(List<Chatroom> chatrooms) {
        this.chatrooms = chatrooms;
    }

    /**
     * Retrieves the messages from a room
     * @param roomName - room to get the messages
     * @return
     */
    public List<Message> getRoomMessage(String roomName){
        Chatroom found = findChatroom(roomName);
        return found.getMessageList();
    }

    /**
     *  Removes a user from the connection
     * @param name - user to remove
     * @return
     */
    public String removeUser(String name){
        User found = findUser(name);
        connectedUsers.removeIf(u -> u.getName().equals(found.getName()));
        return "User" + found.getName() + " has been removed.";
    }

    /**
     * Helper function to find the user
     * @param name - user to find
     * @return found user
     */
    private User findUser(String name){
        User found = null;
        for (User user : connectedUsers){
            if (name.equals(user.getName())){
                found = user;
            }
        }
        return found;

    }

    /**
     * Helper function to find the chatroom
     * @param name - chatroom to find
     * @return found the room
     */
    private Chatroom findChatroom(String name){
        Chatroom found = null;
        for (Chatroom chatroom : chatrooms){
            if (chatroom.getName().equals(name)){
                found = chatroom;
            }
        }
        return found;
    }
}
