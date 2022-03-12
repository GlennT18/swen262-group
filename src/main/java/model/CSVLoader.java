package model;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CSVLoader {
    static final String ARTISTS_CSV = "src/main/resources/artists.csv";
    static final String SONGS_CSV = "src/main/resources/songs.csv";
    static final String RELEASES_CSV = "src/main/resources/releases.csv";

//    public static List<Artist> loadArtists() throws CsvValidationException, IOException {
//        System.out.println("Loading Artists...");
//        HashMap<Artist> artists = new ArrayList<Artist>();
//
//        CSVReader reader = new CSVReader(new FileReader(ARTISTS_CSV));
//        String [] nextLine;
//        while ((nextLine = reader.readNext()) != null) {
//            // GUID, Name, Type (optional)
//            Artist currentArtist = new Artist(nextLine[0], nextLine[1], nextLine[2]);
//            artists.add(currentArtist);
//        }
//        return artists;
//    }

//    private static List<Song> loadSongs() throws CsvValidationException, IOException {
//        System.out.println("Loading Songs...");
//        ArrayList<Song> artists = new ArrayList<Song>();
//
//        CSVReader reader = new CSVReader(new FileReader(SONGS_CSV));
//        String [] nextLine;
//        while ((nextLine = reader.readNext()) != null) {
//            // GUID, Artist-GUID, Duration, Title
//            Song currentSong = new Song(nextLine[0], nextLine[1], nextLine[2], nextLine[3]);
//            artists.add(currentArtist);
//        }
//        return artists;
//    }

}
