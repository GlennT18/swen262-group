package model;

import java.util.Date;
import java.util.List;

public class Release {
    private final String guid;
    private final String title;
    private final Artist artist;
    private final Date issueDate;
    private final Medium medium;
    private final List<Song> trackList;

    public Release(String guid, String title, Artist artist, Date issueDate, Medium medium, List<Song> trackList) {
        this.guid = guid;
        this.title = title;
        this.artist = artist;
        this.issueDate = issueDate;
        this.medium = medium;
        this.trackList = trackList;
    }

    public void addSong(Song song) {
        trackList.add(song);
    }

    public void removeSong(Song song) {
        trackList.remove(song);
    }
}
