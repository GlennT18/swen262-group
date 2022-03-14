package controller.sort;

import model.Release;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Tested by Nick

public class ReleaseRatingSort implements Sorter {
    @Override
    public void sortData(List data) {
        // Sort by rating
        Collections.sort(data, Comparator.comparing(Release::getAverageRating));
    }
}
