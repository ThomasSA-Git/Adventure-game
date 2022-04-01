package com.company;

import java.util.ArrayList;

public class Creator {

  Room firstRoom;
  Player player;

  public void createRooms() {

    Prisoner prisoner = new Prisoner("Prisoner", "Chili crazed prisoner", new Food("biscuits", 1));

    Parrot parrot = new Parrot("parrot", "Disease-ridden parrot", null);


    Figurehead figurehead = new Figurehead("Figurehead", "A beautifully carved figurehead painted in gold resembling a mermaid.\n" +
        "It really gives the ship a majestic look", null);
    Room room1 = new Room("Cabin", "You find yourself in what looks like a cabin on a larger ship. The room has one door\n" +
        "You feel the shift of gravity going from one end of the room to the other in a rhythmic motion\n" +
        "Atop the sheets of one of the bunk beds you spot a shiny object\n" +
        "The room contains:\n", new ArrayList<Item>(), new ArrayList<Door>(), null, null, new ArrayList<Box>(), new ArrayList<Inspectables>());


    Room room2 = new Room("Galley", "You look around to see that you find yourself in a quaint small kitchen.\n" +
        "This must be the galley of the ship.\n" +
        "On the kitchen isle is a small electrical stove with one pot sitting on top\n" +
        "In the sink lies a dirty frying pan, someone refused to wash (inspired by true events)\n" +
        "Opposite the door where you entered, there's another white door", new ArrayList<Item>(), new ArrayList<Door>(), null, null, new ArrayList<Box>(), new ArrayList<Inspectables>());

    Room room3 = new Room("Ship Hold", "Barrels, crates, bags and sacks. This is clearly the hold of the ship\n" +
        "To your left there's a small staircase leading up to a hatch.\n" +
        "In front of you, you see an old rusty metal door.\n" +
        "Otherwise, the only thing that catches your eye is one specific crate with a skull on it." +
        "", new ArrayList<Item>(), new ArrayList<Door>(), null, null, new ArrayList<Box>(), new ArrayList<Inspectables>());

    Room room4 = new Room("Brig", "This room smells like booze and something else absolutely ghastly.\n" +
        "to the left you see a wall of metal bars. A jail cell. This must be the brig\n" +
        "Inside sits a ragged man with a crooked smile." +
        "Next to him in the corner of his cell sits a bucket which is obviously the source of the foul smell.\n" +
        "After a more thorough peak you realise the bucket is full of (you guessed it) anchovies.", new ArrayList<Item>(), new ArrayList<Door>(), prisoner, null, new ArrayList<Box>(), new ArrayList<Inspectables>());

    Room room5 = new Room("Deck (Stern)", "Finally fresh air. The ship is surrounded by ocean as far as the eye can see.\n" +
        "In the middle of the deck stands the capstan with a large lever besides it\n" +
        "You look up and spot something shiny in the ship's mast", new ArrayList<Item>(), new ArrayList<Door>(), parrot, null, new ArrayList<Box>(), new ArrayList<Inspectables>());

    Room room6 = new Room("Deck (Bow)", "You stand at the foot of the ships mast.\n" +
        "A robe ladder leads up to the crow's nest", new ArrayList<Item>(), new ArrayList<Door>(), figurehead, null, new ArrayList<Box>(), new ArrayList<Inspectables>());

    Room room7 = new Room("Mast", "Even with this view, there's no land in sight. There's however, a parrot sitting on the railing.\n" +
        "The parrot is screetching several controversal political opinions. How highly inapropriate.", new ArrayList<Item>(), new ArrayList<Door>(), null, null, new ArrayList<Box>(), new ArrayList<Inspectables>());

    Room room8 = new Room("Bridge Deck", "A sense of power washes over you when you stand before the ships helm.\n" +
        "Upon closer inspection, the helm is not attached to anything.\n" +
        "On the wall is an emergency glass cabinet.", new ArrayList<Item>(), new ArrayList<Door>(), null, null, new ArrayList<Box>(), new ArrayList<Inspectables>());

    Room room9 = new Room("Captains Quarters", "", new ArrayList<Item>(), new ArrayList<Door>(), null, null, new ArrayList<Box>(), new ArrayList<Inspectables>());

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

    //CONTAINS
    room2.addToBoxes(new Box("soup", new Item("spicy soup"), true, "hot sauce", "You pour the entire bottle in and use a spoon to stir the pot.\n" +
        "The spoon deteriorates beyond recognision\n" +
        "You take the spicy soup"));

    //INVENTORY
    room2.addToInventory(new MeleeWeapon("frying pan", 3, 5));

    //CONNECTIONS
    room2.setEast(room3);
    room2.setWest(room1);

    //ROOM 3 (Ship Hold)

    //DOORS
    room3.addToDoors(new Door("rusty door", false, null, room4));
    room3.addToDoors(new Door("hatch", true, "hatch key", room5));
    room3.addToDoors(new Door("white door", false, null, room2));

    //CONTAINS
    room3.addToInspectables(new Inspectables("crate"));

    //CONNECTIONS
    room3.setWest(room2);
    room3.setEast(room4);
    room3.setNorth(room5);

    //ROOM 4 (Brig)
    room4.setWest(room3);

    //DOORS
    room4.addToDoors(new Door("rusty door", false, null, room3));

    //ROOM 5 (Stern)

    //CONTAINS
    room5.addToBoxes(new Box("lever", new Item ("hammer"), false, null, "You pull the lever and watch as the capstan spins dropping the anchor at rapid speed.\n" +
        "The thud of the anchor hitting the sea floor shifts the ship enough that something falls from the mast.\n" +
            "It's a hammer. You take it."));

    //CONNECTIONS
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

    //CONTAINS
    room8.addToBoxes(new Box("glass cabinet",new Item("hot sauce"), true, "hammer", "You smash the glass with the hammer. A bottle of hot sauce was inside.\n" +
        "You take the hot sauce"));
    room8.addToDoors(new CodeDoor("wide door", true, null, room9, "1234", "You hear a clicking noise. It's unlocked"));

    //CONNECTIONS
    room8.setEast(room5);
    room9.setSouth(room9);


    //ROOM 9 (Captains Quarters)
    room9.setNorth(room8);
  }
}
