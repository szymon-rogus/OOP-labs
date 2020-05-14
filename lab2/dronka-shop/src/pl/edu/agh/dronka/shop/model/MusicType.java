package pl.edu.agh.dronka.shop.model;

public enum MusicType {
    POP("Pop"), ROCK("Rock");

    private String displayName;

    public String getDisplayName() {
        return displayName;
    }

    private MusicType(String displayName) {
        this.displayName = displayName;
    }
}
