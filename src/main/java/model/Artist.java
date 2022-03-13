package model;

import java.io.Serializable;

public class Artist implements Serializable {
    private final String guid;
    private final String name;
    private final String type;

    public Artist(String guid, String name, String type) {
        this.guid = guid;
        this.name = name;
        this.type = type;
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

    @Override
    public String toString() {
        return "Artist{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
