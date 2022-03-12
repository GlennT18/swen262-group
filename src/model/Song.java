package model;

public class Song {
    private final String title;
    private final Artist artist;
    private final double duration;
    private final int rating;

    public Song(String title, Artist artist, double duration, int rating) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.rating = rating;
    }
}
