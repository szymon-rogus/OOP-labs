package pl.agh.edu.dp.labirynth;

public class Door extends MapSite {

    private Room room1;
    private Room room2;

    public Door(Room r1, Room r2){
        this.room1 = r1;
        this.room2 = r2;
    }


    @Override
    public void Enter(){

    }

    public Room getRoom1() {
        return room1;
    }

    public void setRoom1(Room room1) {
        this.room1 = room1;
    }

    public Room getRoom2() {
        return room2;
    }

    public void setRoom2(Room room2) {
        this.room1 = room2;
    }

    public static class SpecialDoor extends Door {
        private Direction from;
        private Direction to;

        public SpecialDoor(Room r1, Room r2) {
            super(r1, r2);
            this.from = Direction.North;
            this.to = Direction.South;
        }
    }
}
