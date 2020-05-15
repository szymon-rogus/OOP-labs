package pl.agh.edu.dp.labirynth;
//
public class MazeFactory {
    private static final MazeFactory SINGLETON = new MazeFactory();
    private MazeFactory(){

    }

    public static MazeFactory getInstance() {
        return SINGLETON;
    }

    public Maze createMaze() {
        return new Maze();
    }

    public Room createRoom(int roomId) {
        return new Room(roomId);
    }

    public Wall createWall() {
        return new Wall();
    }

    public Door createDoor(Room room1, Room room2) {
        return new Door(room1, room2);
    }
}
