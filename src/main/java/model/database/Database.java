package model.database;

import model.Artist;
import model.Release;
import model.Song;

import java.util.HashMap;

public interface Database {
    void initialize();
    void save();
    HashMap<String, Artist> getArtists();
    HashMap<String, Song> getSongs();
    HashMap<String, Release> getReleases();
    void addArtist(Artist artist);
    void addSong(Song song);
    void addRelease(Release release);
}
