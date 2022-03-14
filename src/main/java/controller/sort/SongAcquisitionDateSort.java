package controller.sort;

import model.Song;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Tested by Nick

public class SongAcquisitionDateSort implements Sorter {
    @Override
    public void sortData(List data) {
        // Sort by acquisition date of the songs
        Collections.sort(data, Comparator.comparing(Song::getAcquiredDate));
    }
}
