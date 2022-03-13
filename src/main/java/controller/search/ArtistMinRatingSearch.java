package controller.search;

import model.Artist;
import model.database.AllMusic;
import model.database.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Tested by Nick

public class ArtistMinRatingSearch implements Searcher{
    @Override
    public List performSearch(String query, Database db) {
        if (db instanceof AllMusic) {
            // AllMusic doesn't have rating so this search would not apply
            return null;
        }

        // Convert query to integer
        int queryInt;
        try {
            queryInt = Integer.parseInt(query);
        } catch (NumberFormatException e) {
            return null;
        }

        ArrayList<Artist> results = new ArrayList<>();

        HashMap<String, Artist> artists = db.getArtists();
        for (Artist artist: artists.values()) {
            if (artist.getAverageRating() >= queryInt) {
                results.add(artist);
            }
        }
        return results;
    }
}
