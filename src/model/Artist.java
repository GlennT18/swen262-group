package model;

public class Artist {
    private final String guid;
    private final String name;
    private final ArtistType type;

    public Artist(String guid, String name, ArtistType type) {
        this.guid = guid;
        this.name = name;
        this.type = type;
    }
}
