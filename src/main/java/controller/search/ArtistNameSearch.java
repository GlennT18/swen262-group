package controller.search;

import model.Artist;
import model.database.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

// Tested by Nick

public class ArtistNameSearch implements Searcher{
    @Override
    public List performSearch(String query, Database db) {
        ArrayList<Artist> results = new ArrayList<>();

        HashMap<String, Artist> artists = db.getArtists();
        for (Artist artist: artists.values()) {
            if (artist.getName().toLowerCase().contains(query)) {
                results.add(artist);
            }
        }
        return results;
    }
}
