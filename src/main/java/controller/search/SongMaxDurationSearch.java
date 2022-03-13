package controller.search;

import model.Song;
import model.database.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Tested by Nick

public class SongMaxDurationSearch implements Searcher{
    @Override
    public List performSearch(String query, Database db) {
        ArrayList<Song> results = new ArrayList<>();

        // Convert query to integer
        int queryInt;
        try {
            queryInt = Integer.parseInt(query);
        } catch (NumberFormatException e) {
            return null;
        }

        HashMap<String, Song> songs = db.getSongs();
        for (Song song: songs.values()) {
            if (song.getDuration() <= queryInt) {
                results.add(song);
            }
        }
        return results;
    }
}
