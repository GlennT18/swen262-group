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
    public Artist addArtist(Artist artist) {
        // Copy artist
        Artist newArtist = new Artist(artist.getGuid(), artist.getName(), artist.getType());

        // Put new artist object into this database
        artists.put(newArtist.getGuid(), newArtist);
        return newArtist;
    }

    @Override
    public Song addSong(Song song) {
        // Check if songs artist is in the personal library already
        String artistGuid = song.getArtist().getGuid();
        if (!artists.containsKey(artistGuid)) {
            addArtist(song.getArtist());
        }

        // Get the artist object of the song to be added
        Artist songArtist = artists.get(artistGuid);

        // Copy song
        Song newSong = new Song(song.getGuid(), songArtist, song.getDuration(), song.getTitle());

        // Also add Song to artists song list
        songArtist.addSong(newSong);

        // Put new song into this database
        songs.put(newSong.getGuid(), newSong);
        return newSong;
    }

    @Override
    public Release addRelease(Release release) {
        // Check if release artist is in the personal library already
        String artistGuid = release.getArtist().getGuid();
        if (!artists.containsKey(artistGuid)) {
            addArtist(release.getArtist());
        }

        // Get the artist object of the song to be added
        Artist releaseArtist = artists.get(artistGuid);

        // Add all songs in the release
        Song[] newTrackList = new Song[release.getTrackList().length];
        int trackNum = 0;
        for (Song s : release.getTrackList()) {
            newTrackList[trackNum] = addSong(s);
            trackNum++;
        }

        // Copy release
        Release newRelease = new Release(
                release.getGuid(),
                release.getTitle(),
                releaseArtist,
                release.getIssueDate(),
                release.getMedium(),
                newTrackList);

        // Put new release into this database
        releases.put(newRelease.getGuid(), newRelease);
        return newRelease;
    }
}
