package com.company;

import java.util.ArrayList;

public class Creator {

  Room firstRoom;
  Player player;

  public void createRooms() {

    Prisoner prisoner = new Prisoner("Prisoner", "Chili crazed prisoner", new Food("biscuits", 1));
    Parrot parrot = new Parrot("Shark Bait the parrot", "Disease-ridden parrot", null);
    Room room1 = new Room("Cabin", "You find yourself in what looks like a cabin on a larger ship. The room has one door\n" +
        "You feel the shift of gravity going from one end of the room to the other in a rhythmic motion\n" +
        "Atop the sheets of one of the bunk beds you spot a shiny object\n" +
        "The room contains:\n", new ArrayList<Item>(), new ArrayList<Door>(), null, null);

    room1.addToInventory(new Food("bowl of chili", 2));

    Room room2 = new Room("Galley", "You look around to see that you find yourself in a quaint small kitchen.\n" +
        "This must be the galley of the ship.\n" +
        "On the kitchen isle is a small electrical stove with one pot sitting on top\n" +
        "In the sink lies a dirty frying pan, someone refused to wash (inspired by true events)\n" +
        "Opposite the door where you entered, there's another white door", new ArrayList<Item>(), new ArrayList<Door>(), null, null);

    Room room3 = new Room("Ship Hold", "Barrels, crates, bags and sacks. This is clearly the hold of the ship\n" +
        "To your left there's a small staircase leading up to a hatch.\n" +
        "In front of you, you see an old rusty metal door.\n" +
        "Otherwise, the only thing that catches your eye is one specific crate with a skull on it." +
        "", new ArrayList<Item>(), new ArrayList<Door>(), null, null);

    Room room4 = new Room("Brig", "This room smells like booze and something else absolutely ghastly.\n" +
        "to the left you see a wall of metal bars. A jail cell. This must be the brig\n" +
        "Inside sits a ragged man with a crooked smile." +
        "Next to him in the corner of his cell sits a bucket which is obviously the source of the foul smell." +
        "After a more thorough peak you realise the bucket is full of (you guessed it) anchovies.", new ArrayList<Item>(), new ArrayList<Door>(), prisoner, null);

    Room room5 = new Room("Deck (Stern)", "Finally fresh air. The ship is surrounded by ocean as far as the eye can see.\n" +
        "In the middle of the deck stands the capstan with a large lever besides it\n" +
        "You look up and spot something shiny in the ship's mast", new ArrayList<Item>(), new ArrayList<Door>(), null, null);

    Room room6 = new Room("Deck (Bow)", "You stand at the foot of the ships mast.\n" +
        "A robe ladder leads up to the crow's nest", new ArrayList<Item>(), new ArrayList<Door>(), null, null);

    Room room7 = new Room("Mast", "Even with this view, there's no land in sight. There's however, a parrot sitting on the railing.\n" +
        "The parrot is screetching several controversal political opinions. How highly inapropriate.", new ArrayList<Item>(), new ArrayList<Door>(), null, null);

    Room room8 = new Room("Bridge Deck", "A sense of power washes over you when you stand before the ships helm.\n" +
        "Upon closer inspection, the helm is not attached to anything.\n" +
        "On the wall is an emergency glass cabinet.", new ArrayList<Item>(), new ArrayList<Door>(), null, null);

    Room room9 = new Room("Captains Quarters", "", new ArrayList<Item>(), new ArrayList<Door>(), null, null);

    firstRoom = room1;

    //ROOM 1 (Cabin)
    //CONNECTIONS
    room1.setEast(room2);

    //DOOR
    room1.addToDoors(new Door("heavy door", true, "shiny key", room2, "You fumble a bit with the keys and drop on the ground.\n The keys slide through a grate at your feet.\n" +
        "The narrator sighs in distraught and unlocks the door"));

    //INVENTORY
    room1.addToInventory(new Item("shiny key"));
    System.out.println(room1.getMapInventory());

    //ROOM 2 (Galley)

    //DOORS
    room2.addToDoors(new Door("heavy door", false, null, room1));
    room2.addToDoors(new Door("white door", false, null, room3));

    //INVENTORY
    room2.addToInventory(new MeleeWeapon("frying pan", 3, 5));
    room2.addToInventory(new Item("soup"));

    //CONNECTIONS
    room2.setEast(room3);
    room2.setWest(room1);

    //ROOM 3 (Ship Hold)

    room3.setWest(room2);
    room3.setEast(room4);
    room3.setNorth(room5);

    //ROOM 4 (Brig)
    room4.setWest(room3);

    //ROOM 5 (Stern)
    room5.setSouth(room3);
    room5.setEast(room6);
    room5.setWest(room8);
    room5.setDoorLocked();

    //ROOM 6 (Bow)
    room6.setWest(room5);
    room6.setNorth(room7);

    //ROOM 7 (Mast)
    room7.setSouth(room6);

    //ROOM 8 (Bridge Deck)
    room8.setEast(room5);
    room9.setSouth(room9);

    //ROOM 9 (Captains Quarters)
    room9.setNorth(room8);
  }
}
