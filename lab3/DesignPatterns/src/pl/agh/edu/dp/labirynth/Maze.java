package pl.agh.edu.dp.labirynth;

import java.util.Iterator;
import java.util.Vector;

public class Maze {
    public Vector<Room> getRooms() {
        return rooms;
    }

    public Vector<Door> getDoors() {
        return doors;
    }

    private Vector<Room> rooms;
    private Vector<Door> doors;

    public Maze() {
        this.rooms = new Vector<Room>();
        this.doors = new Vector<Door>();
    }

    private boolean checkForDirection(Direction direction1, Direction direction2) {
        if (direction1 == Direction.North && direction2 != Direction.South
                || direction1 == Direction.South && direction2 != Direction.North)
            return false;
        if (direction1 == Direction.East && direction2 != Direction.West
                || direction1 == Direction.West && direction2 != Direction.East)
            return false;
        return true;
    }

    public void createDoor(int room1_Id, Direction direction1, int room2_Id, Direction direction2) throws IllegalAccessException {
        if(!checkForDirection(direction1, direction2)){
            throw new IllegalAccessException("Cannot create doors like that!");
        }
        Room room1 = getRoomById(room1_Id);
        Room room2 = getRoomById(room2_Id);

        Door door = new Door(room1, room2);
        doors.add(door);

        if (room1 != null) {
            room1.setSide(direction1, door);
        }
        if (room2 != null) {
            room2.setSide(direction2, door);
        }
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room getRoomById(int roomId) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomId)
                return room;
        }
        return null;
    }

    public void setRooms(Vector<Room> rooms) {
        this.rooms = rooms;
    }

    public int getRoomNumbers() {
        return rooms.size();
    }

    // MazeBuilder is a simple builder for Maze class
    public interface MazeBuilder {
        Vector<Room> rooms = new Vector<Room>();
        Vector<Door> doors = new Vector<Door>();

        public Maze build();
    }
    // what
    public static class StandardBuilderMaze implements MazeBuilder {
        private Maze currentMaze;

        public StandardBuilderMaze() {
            super();
        }

        public StandardBuilderMaze addRoom( Room room) {
            if(!checkForRoom(room.getRoomNumber())){
                throw new IllegalStateException("Room with " + room.getRoomNumber() + " already in Maze");
            }
            rooms.add(room);
            return this;
        }

        public StandardBuilderMaze createRoomWithWalls(int roomId) {
            if(!checkForRoom(roomId)){
                throw new IllegalStateException("Room with " + roomId + " already in Maze");
            }
            Room room = new Room(roomId);
            setWalls(room);
            rooms.add(room);
            return this;
        }

        private void setWalls(Room room) {
            room.setSide(Direction.North, new Wall());
            room.setSide(Direction.East, new Wall());
            room.setSide(Direction.South, new Wall());
            room.setSide(Direction.West, new Wall());
        }

        private boolean checkForDirection(Direction direction1, Direction direction2) {
            if (direction1 == Direction.North && direction2 != Direction.South
                    || direction1 == Direction.South && direction2 != Direction.North)
                return false;
            if (direction1 == Direction.East && direction2 != Direction.West
                    || direction1 == Direction.West && direction2 != Direction.East)
                return false;
            return true;
        }

        private boolean checkForRoom(int roomId) {
            return this.rooms.stream()
                    .noneMatch(roomIn -> roomIn.getRoomNumber() == roomId);
        }

        private Room getRoomById(int roomId) {
            for (Iterator<Room> iterator = rooms.iterator(); iterator.hasNext(); ) {
                Room room = iterator.next();
                if (room.getRoomNumber() == roomId) ;
                    return room;
            }
            return null;
        }
        //
        public Maze build() {

            if(rooms.isEmpty()) {
                throw new IllegalStateException("Cannot create empty Maze");
            }

            Maze maze = new Maze();

            maze.rooms = this.rooms;
            maze.doors = this.doors;

            return maze;
        }
    }
    //
    public class CountingMazeBuilder implements MazeBuilder {

        public int getCounts() {
            int counter = rooms.size() + doors.size();
            return counter;
        }

        public Maze build() {
            int counter = getCounts();
            Maze maze = new Maze();
            return maze;
        }
    }
}
