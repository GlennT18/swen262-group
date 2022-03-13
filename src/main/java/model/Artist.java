package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Artist implements Serializable {
    private final String guid;
    private final String name;
    private final String type;
    private List<Song> songs;

    public Artist(String guid, String name, String type) {
        this.guid = guid;
        this.name = name;
        this.type = type;
        this.songs = new ArrayList<>();
    }

    public String getGuid() {
        return guid;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public float getAverageRating() {
        float totalRating = 0;
        for (Song s : songs) {
            totalRating += s.getRating();
        }
        return totalRating / songs.size();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
