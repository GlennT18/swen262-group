package model;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Database {
    static final String ARTISTS_CSV = "src/main/resources/artists.csv";
    static final String SONGS_CSV = "src/main/resources/songs.csv";
    static final String RELEASES_CSV = "src/main/resources/releases.csv";

    private final HashMap<String, Artist> artists = new HashMap<>(); // GUID -> Artist
    private final HashMap<String, Song> songs = new HashMap<>(); // GUID -> Song
    private final HashMap<String, Release> releases = new HashMap<>(); // GUID -> Release

    public void initialize() throws CsvValidationException, IOException {
        loadArtists();  // Load artists first because the have no references
        loadSongs();    // Next load songs because they only reference artists
        loadReleases(); // Finally, load releases because they reference artists and songs
    }

    private void loadArtists() throws CsvValidationException, IOException {
        System.out.print("Loading Artists...");
        CSVReader reader = new CSVReader(new FileReader(ARTISTS_CSV));
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            // GUID, Name, Type (optional)
            String guid = nextLine[0];
            String artistName = nextLine[1];
            String type = nextLine[2].isEmpty() ? null : nextLine[2]; // if no type then set to null

            // Make artist object from row data and put in the hashmap
            Artist currentArtist = new Artist(guid, artistName, type);
            artists.put(guid, currentArtist);
        }
        System.out.println("Done!");
    }

    private void loadSongs() throws CsvValidationException, IOException {
        System.out.print("Loading Songs...");
        CSVReader reader = new CSVReader(new FileReader(SONGS_CSV));
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            // GUID, Artist-GUID, Duration, Title
            String guid = nextLine[0];
            String artistGUID = nextLine[1];
            int duration = Integer.parseInt(nextLine[2]);
            String title = nextLine[3];

            // Find Artist Object by guid
            Artist songArtist = artists.get(artistGUID);

            // Make song object from row data and put in the hashmap
            Song currentSong = new Song(guid, songArtist, duration, title);
            songs.put(guid, currentSong);
        }
        System.out.println("Done!");
    }

    private void loadReleases() throws CsvValidationException, IOException {
        System.out.print("Loading Releases...");
        CSVReader reader = new CSVReader(new FileReader(RELEASES_CSV));
        String [] nextLine;

        // Initialize datetime formatters
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");

        while ((nextLine = reader.readNext()) != null) {
            // GUID, Artist-GUID, Title, Issue-Date, Medium, Tracks (0..* Song GUIDs)
            String guid = nextLine[0];
            String artistGUID = nextLine[1];
            String title = nextLine[2];
            String medium = nextLine[3];
            String rawIssueDate = nextLine[4];

            // Parse date (either YYYY or YYYY-MM-DD)
            LocalDate issueDate;
            switch (rawIssueDate.length()) {
                case 4: issueDate = LocalDate.parse(rawIssueDate + "-01-01", formatter);
                    break;
                case 7: issueDate = LocalDate.parse(rawIssueDate + "-01", formatter);
                    break;
                default: issueDate = LocalDate.parse(rawIssueDate, formatter);
                    break;
            }

            // Find Artist Object by guid
            Artist releaseArtist = artists.get(artistGUID);

            // Find each Song Object by GUID and add to the songs list
            int songCount = nextLine.length - 5;
            Song[] releaseSongs = new Song[songCount];
            int releaseSongsIndex = 0;
            for (int i = 5; i < nextLine.length; i++) {
                Song releaseSong = songs.get(nextLine[i]);
                releaseSongs[releaseSongsIndex] = releaseSong;
                releaseSongsIndex++;
            }

            // Make release object from row data and put in the hashmap
            Release currentRelease = new Release(guid, title, releaseArtist, issueDate, medium, releaseSongs);
            releases.put(guid, currentRelease);
        }
        System.out.println("Done!");
    }
}
