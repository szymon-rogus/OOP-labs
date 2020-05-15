package pl.agh.edu.dp.labirynth;

public abstract class MapSite {
    public int getDoorId() {
        return doorId;
    }

    public void setDoorId(int doorId) {
        this.doorId = doorId;
    }

    protected int doorId;

    public abstract void Enter();
}
