package controller.sort;

import model.Song;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Tested by Nick

public class SongAlphaSort implements Sorter {
    @Override
    public void sortData(List data) {
        // Sort alphabetically by title of the songs
        Collections.sort(data, Comparator.comparing(Song::getTitle));
    }
}
