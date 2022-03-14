package controller.sort;

import model.Release;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Tested by Nick

public class ReleaseAlphaSort implements Sorter {
    @Override
    public void sortData(List data) {
        // Sort by release title alphabetically
        Collections.sort(data, Comparator.comparing(Release::getTitle));
    }
}
