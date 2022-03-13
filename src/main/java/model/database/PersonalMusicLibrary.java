package model.database;

import model.Artist;
import model.Release;
import model.Song;

import java.io.*;
import java.util.HashMap;

public class PersonalMusicLibrary implements Database {
    static final String SAVE = "personalMusicLibrarySave";

    private HashMap<String, Artist> artists;      // GUID -> Artist
    private HashMap<String, Song> songs;          // GUID -> Song
    private HashMap<String, Release> releases;    // GUID -> Release

    public PersonalMusicLibrary() {
        initialize();
    }

    public void initialize() {
        try {
            FileInputStream saveFile = new FileInputStream(SAVE);
            ObjectInputStream objectInputStream = new ObjectInputStream(saveFile);

            // Read objects from file
            artists = (HashMap<String, Artist>) objectInputStream.readObject();
            songs = (HashMap<String, Song>) objectInputStream.readObject();
            releases = (HashMap<String, Release>) objectInputStream.readObject();

            objectInputStream.close();
            saveFile.close();
        } catch (IOException | ClassNotFoundException e) {
            // If there are issues reading the save file then just start with an empty database
            artists = new HashMap<>();
            songs = new HashMap<>();
            releases = new HashMap<>();
        }
    }

    public void save() {
        try {
            FileOutputStream saveFile = new FileOutputStream(SAVE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(saveFile);

            // Write objects to file
            objectOutputStream.writeObject(artists);
            objectOutputStream.writeObject(songs);
            objectOutputStream.writeObject(releases);

            objectOutputStream.close();
            saveFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public HashMap<String, Artist> getArtists() {
        return artists;
    }

    @Override
    public HashMap<String, Song> getSongs() {
        return songs;
    }

    @Override
    public HashMap<String, Release> getReleases() {
        return releases;
    }

    @Override
    public void addArtist(Artist artist) {
        artists.put(artist.getGuid(), artist);
    }

    @Override
    public void addSong(Song song) {
        songs.put(song.getGuid(), song);
    }

    @Override
    public void addRelease(Release release) {
        releases.put(release.getGuid(), release);
    }
}
