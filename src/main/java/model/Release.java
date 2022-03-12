package model;

import java.time.LocalDate;

public class Release {
    private final String guid;
    private final String title;
    private final Artist artist;
    private final LocalDate issueDate;
    private final String medium;
    private final Song[] trackList;

    public Release(String guid, String title, Artist artist, LocalDate issueDate, String medium, Song[] trackList) {
        this.guid = guid;
        this.title = title;
        this.artist = artist;
        this.issueDate = issueDate;
        this.medium = medium;
        this.trackList = trackList;
    }
}
