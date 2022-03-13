package controller.search;

import model.Release;
import model.database.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Tested by Nick

public class ReleaseMinDurationSearch implements Searcher{
    @Override
    public List performSearch(String query, Database db) {
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
            if (release.getTotalDuration() >= queryInt) {
                results.add(release);
            }
        }
        return results;
    }
}
