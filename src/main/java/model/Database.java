package model;

import java.util.HashMap;

public interface Database {
    void initialize();
    HashMap<String, Artist> getArtists();
    HashMap<String, Song> getSongs();
    HashMap<String, Release> getReleases();
    void addArtist(Artist artist);
    void addSong(Song song);
    void addRelease(Release release);
}
