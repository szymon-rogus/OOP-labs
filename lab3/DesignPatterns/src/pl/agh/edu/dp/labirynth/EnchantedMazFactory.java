package pl.agh.edu.dp.labirynth;
//
public class EnchantedMazFactory {

    //@Override
    public Room createRoom(int roomId) {
        return new Room.SmallRoom(roomId);
    }

    //@Override
    public Wall createWall() {
        return new Wall.CommonWall();
    }

    //@Override
    public Door createDoor(Room room1, Room room2) {
        return new Door.SpecialDoor(room1, room2);
    }
}
