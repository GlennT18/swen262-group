package controller.sort;

import model.Artist;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Tested by Nick

public class ArtistAlphaSort implements Sorter {
    @Override
    public void sortData(List data) {
        // Sort alphabetically by artist name
        Collections.sort(data, Comparator.comparing(Artist ::getName));
    }
}
