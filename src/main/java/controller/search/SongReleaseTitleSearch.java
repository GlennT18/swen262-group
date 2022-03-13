package controller.search;

import model.Release;
import model.Song;
import model.database.Database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// Tested by Nick

public class SongReleaseTitleSearch implements Searcher{
    @Override
    public List performSearch(String query, Database db) {
        ArrayList<Song> results = new ArrayList<>();

        HashMap<String, Release> releases = db.getReleases();
        for (Release release: releases.values()) {
            if (release.getTitle().contains(query))
                results.addAll(Arrays.asList(release.getTrackList()));
        }
        return results;
    }
}
