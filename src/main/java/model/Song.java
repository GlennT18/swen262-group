package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Song implements Serializable {
    private final String guid;
    private final Artist artist;
    private final int duration;
    private final String title;

    private int rating = 0;
    private LocalDate acquiredDate;

    public Song(String guid, Artist artist, int duration, String title) {
        this.guid = guid;
        this.artist = artist;
        this.duration = duration;
        this.title = title;
    }

    public String getGuid() {
        return guid;
    }

    public Artist getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDate getAcquiredDate() {
        return acquiredDate;
    }

    public void setAcquiredDate(LocalDate acquiredDate) {
        this.acquiredDate = acquiredDate;
    }

    @Override
    public String toString() {
        return "Song{" +
                "guid='" + guid + '\'' +
                ", artist=" + artist +
                ", duration=" + duration +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", acquiredDate=" + acquiredDate +
                '}';
    }
}
