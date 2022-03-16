package com.company.backend;

import com.company.backend.Room;

public class RoomCreator {

    Room room1;
    Room room2;
    Room room3;
    Room room4;
    Room room5;
    Room room6;
    Room room7;
    Room room8;
    Room room9;
    Room currentRoom;

    public RoomCreator() {
        this.room1 = new Room("Cabin", """
                You find yourself in what looks like a cabin on a larger ship. The room has one door
                You feel the shift of gravity going from one end of the room to the other in a rhythmic motion
                Next to one of the bunk beds you see a large wooden crate""");

        this.room2 = new Room("Room: 2", "");
        this.room3 = new Room("Room: 3", "");
        this.room4 = new Room("Room: 4", "");
        this.room5 = new Room("Room: 5", "");
        this.room6 = new Room("Room: 6", "");
        this.room7 = new Room("Room: 7", "");
        this.room8 = new Room("Room: 8", "");
        this.room9 = new Room("Room: 9", "");
        this.currentRoom = room1;
    }

    public void connectRooms() {

        //ROOM 1
        room1.setEast(room2);
        room1.setSouth(room4);

        //ROOM 2
        room2.setEast(room3);
        room2.setWest(room1);

        //ROOM 3
        room3.setWest(room2);
        room3.setSouth(room6);

        //ROOM 4
        room4.setNorth(room1);
        room4.setSouth(room7);

        //ROOM 5
        room5.setSouth(room8);
        room5.setDoorLocked();

        //ROOM 6
        room6.setNorth(room3);
        room6.setSouth(room9);

        //ROOM 7
        room7.setNorth(room4);
        room7.setEast(room8);

        //ROOM 8
        room8.setNorth(room5);
        room8.setWest(room7);
        room8.setEast(room9);

        //ROOM 9
        room9.setNorth(room6);
        room9.setWest(room8);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }
}
