import controller.QueryManager;
import controller.search.*;
import model.Release;
import model.Song;
import model.database.AllMusic;
import model.database.Database;
import model.database.PersonalMusicLibrary;

import java.util.List;

public class Application {
    public static void printList(List list) {
        if (list != null) {
            System.out.println("[");
            for (Object o : list) {
                System.out.println(o);
            }
            System.out.println("]");
        } else {
            System.out.println("List is null.");
        }
    }

    public static void main(String[] args) {
        // Initial Setup of Databases
        Database allMusic = new AllMusic();
        Database personalLibrary = new PersonalMusicLibrary();

        // Init QueryManager
        QueryManager queryManager = new QueryManager();

//        // Test ArtistNameSearch
//        Searcher artistNameSearch = new ArtistNameSearch();
//        queryManager.setDatabase(allMusic);
//        queryManager.setSearcher(artistNameSearch);
//        queryManager.setArgument("The");
//        printList(queryManager.executeQuery());

//        // Test ArtistTypeSearch
//        Searcher artistTypeSearch = new ArtistTypeSearch();
//        queryManager.setDatabase(allMusic);
//        queryManager.setSearcher(artistTypeSearch);
//        queryManager.setArgument("US");
//        printList(queryManager.executeQuery());

//        // Test ArtistTypeSearch
//        // Add songs and rate them
//        Song addedSong = personalLibrary.addSong(
//                allMusic.getSongs().get("6e33056b-2a34-4ed0-b49c-f7a8ae2c5bcc")
//        );
//        addedSong.setRating(1);
//
//        Song addedSong2 = personalLibrary.addSong(
//                allMusic.getSongs().get("dc2f8125-f42d-4498-b0f6-57dc18492caf")
//        );
//        addedSong2.setRating(5);
//
//        Searcher artistMinRatingSearch = new ArtistMinRatingSearch();
//        queryManager.setDatabase(personalLibrary);
//        queryManager.setSearcher(artistMinRatingSearch);
//        queryManager.setArgument("2");
//        printList(queryManager.executeQuery());

        // Test SongTitleSearch
//        Searcher songTitleSearch = new SongTitleSearch();
//        queryManager.setDatabase(allMusic);
//        queryManager.setSearcher(songTitleSearch);
//        queryManager.setArgument("The");
//        printList(queryManager.executeQuery());

        // Test SongArtistNameSearch
//        Searcher songArtistNameSearch = new SongArtistNameSearch();
//        queryManager.setDatabase(allMusic);
//        queryManager.setSearcher(songArtistNameSearch);
//        queryManager.setArgument("Weezer");
//        printList(queryManager.executeQuery());

        // Test SongArtistNameSearch
//        Searcher songArtistGuidSearch = new SongArtistGuidSearch();
//        queryManager.setDatabase(allMusic);
//        queryManager.setSearcher(songArtistGuidSearch);
//        queryManager.setArgument("86e736b4-93e2-40ff-9e1c-fb7c63fef5f6");
//        printList(queryManager.executeQuery());




        // Save personalLibrary
        personalLibrary.save();
    }
}
