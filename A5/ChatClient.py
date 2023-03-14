import json
import requests

# Base URL of the service
API_URL = "http://localhost:8080/"
parameters = {"userName": "testuser1", 
                 "roomName" : "testroom123", 
                 "message" : "testmessage100", 
                 "user" : "testuser1", 
                 "room": "testroom123"
                 }

# Handles creation of users
def createUser(new_name):
    parameters["userName"] = new_name
    post = requests.post(API_URL + "createUser", data=parameters)

# Gets the list of chatrooms from the service
def getChatrooms():
    get = requests.get(API_URL + "getChatrooms", params=parameters)
    parsed = json.loads(get.content)

    print("--- Rooms ---")
    for index,rooms in enumerate(parsed):
        print(index+1, rooms['name'])
    print("-------------")

# Handles the sending of messages to the correct chatroom
def sendMessage(message, sender):
    parameters["message"]  = message
    parameters["userName"] = sender
    post = requests.post(API_URL + "message", data=parameters)

# Handles the creation of chatroom
def createRoom(roomName, creator):
    parameters["roomName"] = roomName
    parameters["userName"] = creator
    post = requests.post(API_URL + "createChatroom", data=parameters)

# Handles the user joining a chatroom
def joinRoom(roomName, userName):
    parameters["room"] = roomName
    parameters["userName"] = userName
    post = requests.post(API_URL + "join", data=parameters)

# Handles the leaving of user from a chatroom
def leaveRoom(user):
    parameters["user"] = user
    post = requests.post(API_URL + "leave", data=parameters)

# Retrieve all message from the service
def getMessages(roomName):
    parameters["roomName"] = roomName
    get = requests.get(API_URL + "getRoomMessage", params=parameters)
    parsed = json.loads(get.content)

    for messages in parsed:
        print(messages['sender']['name'] + ": " +messages['message'])

# Use to indicate that the user has entered a room and is ready to send messages
def enteredRoom(user, roomName):
    while True:
        message = input("$> ")
        if (message == "/quit"):
            leaveRoom(user)
            break
        elif (message == "/getm"):
            getMessages(roomName)
        else:
            sendMessage(message, user)

# Tells the service that a user close/exited their client
def exiting(user):
    parameters["user"] = user
    post = requests.post(API_URL + "quit", data=parameters)
    


# Main loop of the program
userName = str(input("Enter a username: "))
createUser(userName)
print("Welcome " + userName + " !")
options = """ 
    OPTIONS:
    1: Create Room
    2: List Rooms
    3: Join Room
    4: EXIT

    Please enter the option number (Enter digits only)
    """


while True:
    print(options)
    choice = input("> ")

    if (choice == "1"):
        roomName = input("Enter a room name: ")
        createRoom(roomName, userName)
        enteredRoom(userName, roomName)

    elif (choice == "2"):
        getChatrooms()

    elif (choice == "3"):
        roomName = input("Enter room to join.")
        joinRoom(roomName, userName)
        enteredRoom(userName, roomName)

    else:
        exiting(userName)
        quit()
