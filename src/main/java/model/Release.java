package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

public class Release implements Serializable {
    private final String guid;
    private final String title;
    private final Artist artist;
    private final LocalDate issueDate;
    private final String medium;
    private final Song[] trackList;

    private LocalDate acquiredDate;

    public Release(String guid, String title, Artist artist, LocalDate issueDate, String medium, Song[] trackList) {
        this.guid = guid;
        this.title = title;
        this.artist = artist;
        this.issueDate = issueDate;
        this.medium = medium;
        this.trackList = trackList;
    }

    public float getAverageRating() {
        float totalRating = 0;
        for (Song s : trackList) {
            totalRating += s.getRating();
        }
        return totalRating / trackList.length;
    }

    public int getTotalDuration() {
        int totalDuration = 0;
        for (Song s : trackList) {
            totalDuration += s.getDuration();
        }
        return totalDuration;
    }

    public String getGuid() {
        return guid;
    }

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setAcquiredDate(LocalDate acquiredDate) {
        this.acquiredDate = acquiredDate;
    }

    public LocalDate getAcquiredDate() {
        return acquiredDate;
    }

    public String getMedium() {
        return medium;
    }

    public Song[] getTrackList() {
        return trackList;
    }

    @Override
    public String toString() {
        return title + " (" + issueDate + ") by: " + artist;
    }
}
