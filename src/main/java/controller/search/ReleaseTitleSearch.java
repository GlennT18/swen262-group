package controller.search;

import model.Release;
import model.database.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Tested by Nick

public class ReleaseTitleSearch implements Searcher{
    @Override
    public List performSearch(String query, Database db) {
        ArrayList<Release> results = new ArrayList<>();

        HashMap<String, Release> releases = db.getReleases();
        for (Release release: releases.values()) {
            if (release.getTitle().contains(query)) {
                results.add(release);
            }
        }
        return results;
    }
}
