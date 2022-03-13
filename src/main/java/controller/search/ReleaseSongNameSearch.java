package controller.search;

import model.Release;
import model.Song;
import model.database.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Tested by Nick

public class ReleaseSongNameSearch implements Searcher{
    @Override
    public List performSearch(String query, Database db) {
        ArrayList<Release> results = new ArrayList<>();

        HashMap<String, Release> releases = db.getReleases();
        for (Release release: releases.values()) {
            for (Song song: release.getTrackList())
                if (song.getTitle().contains(query)) {
                    results.add(release);
                    break; // break so there are no duplicate releases added
                }
        }
        return results;
    }
}
