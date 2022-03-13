package controller.search;

import model.Release;
import model.database.AllMusic;
import model.database.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Tested by Nick

public class ReleaseMinRatingSearch implements Searcher{
    @Override
    public List performSearch(String query, Database db) {
        if (db instanceof AllMusic) {
            // AllMusic doesn't have rating so this search would not apply
            return null;
        }

        ArrayList<Release> results = new ArrayList<>();

        // Convert query to integer
        int queryInt;
        try {
            queryInt = Integer.parseInt(query);
        } catch (NumberFormatException e) {
            return null;
        }

        HashMap<String, Release> releases = db.getReleases();
        for (Release release: releases.values()) {
            if (release.getAverageRating() >= queryInt) {
                results.add(release);
            }
        }
        return results;
    }
}
