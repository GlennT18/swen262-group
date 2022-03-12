package model;

public class Song {
    private final String guid;
    private final Artist artist;
    private final int duration;
    private final String title;

    public Song(String guid, Artist artist, int duration, String title) {
        this.guid = guid;
        this.artist = artist;
        this.duration = duration;
        this.title = title;
    }
}
