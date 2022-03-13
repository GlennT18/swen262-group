package controller.search;

import model.Song;
import model.database.AllMusic;
import model.database.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SongMinRatingSearch implements Searcher{
    @Override
    public List performSearch(String query, Database db) {
        if (db instanceof AllMusic) {
            // AllMusic doesn't have rating so this search would not apply
            return null;
        }

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
            if (song.getRating() >= queryInt) {
                results.add(song);
            }
        }
        return results;
    }
}
