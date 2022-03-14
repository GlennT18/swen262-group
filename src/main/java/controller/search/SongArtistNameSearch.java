package controller.search;

import model.Song;
import model.database.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Tested by Nick

public class SongArtistNameSearch implements Searcher{
    @Override
    public List performSearch(String query, Database db) {
        ArrayList<Song> results = new ArrayList<>();

        HashMap<String, Song> songs = db.getSongs();
        for (Song song: songs.values()) {
            if (song.getArtist().getName().toLowerCase().contains(query)) {
                results.add(song);
            }
        }
        return results;
    }
}
