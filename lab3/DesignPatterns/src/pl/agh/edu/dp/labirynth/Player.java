package pl.agh.edu.dp.labirynth;

import java.util.Vector;

public class Player {

    private Room actualRoom;
    private Vector<Room> rooms;
    private Vector<Door> doors;

    public Player(Room actualRoom, Vector<Room> rooms, Vector<Door> doors) {
        this.actualRoom = actualRoom;
        this.rooms = rooms;
        this.doors = doors;
    }

    public void move(Direction direction) {
        Object mapSite = actualRoom.getSide(direction);

        if(mapSite != null && !(mapSite instanceof Wall)){
            Door door = (Door) mapSite;
            if(actualRoom.getRoomNumber() != door.getRoom1().getRoomNumber()){
                actualRoom = door.getRoom1();
                info();
            }
            else
            if(actualRoom.getRoomNumber() != door.getRoom2().getRoomNumber()){
                actualRoom = door.getRoom2();
                info();
            }
        }
        else
            System.err.println("Cannot cros the Wall!");
    }

    private void info() {
        System.out.println("Moved to room of id: " + actualRoom.getRoomNumber());
    }

}
