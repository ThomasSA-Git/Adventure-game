package com.company;

public class Creator {
  Room currentRoom;


  public void createRooms() {
    Room room1 = new Room("Room: 1", "");
    Room room2 = new Room("Room: 2", "");
    Room room3 = new Room("Room: 3", "");
    Room room4 = new Room("Room: 4", "");
    Room room5 = new Room("Room: 5", "");
    Room room6 = new Room("Room: 6", "");
    Room room7 = new Room("Room: 7", "");
    Room room8 = new Room("Room: 8", "");
    Room room9 = new Room("Room: 9", "");

    currentRoom = room1;

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

  public Room getCurrentRoom(){
    return currentRoom;
  }

  public void setCurrentRoom(Room room){
    this.currentRoom = room;
  }
}
