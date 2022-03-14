import controller.QueryManager;
import controller.search.*;
import controller.sort.*;
import model.Release;
import model.Song;
import model.database.AllMusic;
import model.database.Database;
import model.database.PersonalMusicLibrary;

import java.time.LocalDate;
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

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
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

        // Test SongArtistGuidSearch
//        Searcher songArtistGuidSearch = new SongArtistGuidSearch();
//        queryManager.setDatabase(allMusic);
//        queryManager.setSearcher(songArtistGuidSearch);
//        queryManager.setArgument("86e736b4-93e2-40ff-9e1c-fb7c63fef5f6");
//        printList(queryManager.executeQuery());

        // Test SongReleaseTitleSearch
//        Searcher songReleaseTitleSearch = new SongReleaseTitleSearch();
//        queryManager.setDatabase(allMusic);
//        queryManager.setSearcher(songReleaseTitleSearch);
//        queryManager.setArgument("Wheels");
//        printList(queryManager.executeQuery());

        // Test SongReleaseGuidSearch
//        Searcher songReleaseGuidSearch = new SongReleaseGuidSearch();
//        queryManager.setDatabase(allMusic);
//        queryManager.setSearcher(songReleaseGuidSearch);
//        queryManager.setArgument("930ef9f6-1f75-4fa0-8b53-db31066a42a8");
//        printList(queryManager.executeQuery());

        // Test SongMinDurationSearch
//        Searcher songMinDurationSearch = new SongMinDurationSearch();
//        queryManager.setDatabase(allMusic);
//        queryManager.setSearcher(songMinDurationSearch);
//        queryManager.setArgument("500000");
//        printList(queryManager.executeQuery());

        // Test SongMaxDurationSearch
//        Searcher songMaxDurationSearch = new SongMaxDurationSearch();
//        queryManager.setDatabase(allMusic);
//        queryManager.setSearcher(songMaxDurationSearch);
//        queryManager.setArgument("100000");
//        printList(queryManager.executeQuery());

        // Test SongMinRatingSearch
        // Add songs and rate them
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
//        Searcher songMinRatingSearch = new SongMinRatingSearch();
//        queryManager.setDatabase(personalLibrary);
//        queryManager.setSearcher(songMinRatingSearch);
//        queryManager.setArgument("2");
//        printList(queryManager.executeQuery());

        // Test ReleaseTitleSearch
//        Searcher releaseTitleSearch = new ReleaseTitleSearch();
//        queryManager.setDatabase(allMusic);
//        queryManager.setSearcher(releaseTitleSearch);
//        queryManager.setArgument("F");
//        printList(queryManager.executeQuery());

        // Test ReleaseArtistNameSearch
//        Searcher releaseArtistNameSearch = new ReleaseArtistNameSearch();
//        queryManager.setDatabase(allMusic);
//        queryManager.setSearcher(releaseArtistNameSearch);
//        queryManager.setArgument("Weezer");
//        printList(queryManager.executeQuery());

        // Test ReleaseArtistGUIDSearch
//        Searcher releaseArtistGuidSearch = new ReleaseArtistGuidSearch();
//        queryManager.setDatabase(allMusic);
//        queryManager.setSearcher(releaseArtistGuidSearch);
//        queryManager.setArgument("6fe07aa5-fec0-4eca-a456-f29bff451b04");
//        printList(queryManager.executeQuery());

        // Test ReleaseSongNameSearch
//        Searcher releaseSongNameSearch = new ReleaseSongNameSearch();
//        queryManager.setDatabase(allMusic);
//        queryManager.setSearcher(releaseSongNameSearch);
//        queryManager.setArgument("Particle");
//        printList(queryManager.executeQuery());

        // Test ReleaseSongGuidSearch
//        Searcher releaseSongGuidSearch = new ReleaseSongGuidSearch();
//        queryManager.setDatabase(allMusic);
//        queryManager.setSearcher(releaseSongGuidSearch);
//        queryManager.setArgument("3f6a83bf-64c6-481f-9438-783e3d2bc9a6");
//        printList(queryManager.executeQuery());

        // Test ReleaseMinDurationSearch
//        Searcher releaseMinDurationSearch = new ReleaseMinDurationSearch();
//        queryManager.setDatabase(allMusic);
//        queryManager.setSearcher(releaseMinDurationSearch);
//        queryManager.setArgument("5000000");
//        printList(queryManager.executeQuery());

        // Test ReleaseMaxDurationSearch
//        Searcher releaseMaxDurationSearch = new ReleaseMaxDurationSearch();
//        queryManager.setDatabase(allMusic);
//        queryManager.setSearcher(releaseMaxDurationSearch);
//        queryManager.setArgument("0");
//        printList(queryManager.executeQuery());

        // Test ReleaseMinRatingSearch
        // Add release and rate each song inside
//        Release addedRelease = personalLibrary.addRelease(
//                allMusic.getReleases().get("c4c90ef7-da52-48b4-8c3a-b30c1367e75e")
//        );
//        for (Song s: addedRelease.getTrackList()) {
//            s.setRating(5);
//        }
//
//        Searcher releaseMinRatingSearch = new ReleaseMinRatingSearch();
//        queryManager.setDatabase(personalLibrary);
//        queryManager.setSearcher(releaseMinRatingSearch);
//        queryManager.setArgument("5");
//        printList(queryManager.executeQuery());

        // Test ArtistSorting
//        Searcher artistNameSearch = new ArtistNameSearch();
//        Sorter artistAlphaSort = new ArtistAlphaSort();
//        queryManager.setDatabase(allMusic);
//        queryManager.setSearcher(artistNameSearch);
//        queryManager.setSorter(artistAlphaSort);
//        queryManager.setArgument("The");
//        printList(queryManager.executeQuery());

        // Test SongSorting
        // Add release and rate each song inside
//        Release addedRelease = personalLibrary.addRelease(
//                allMusic.getReleases().get("c4c90ef7-da52-48b4-8c3a-b30c1367e75e")
//        );
//        for (Song s: addedRelease.getTrackList()) {
//            s.setAcquiredDate(LocalDate.of(getRandomNumber(1900, 2200), 1, 1));
//        }
//        Searcher songTitleSearch = new SongTitleSearch();
//        Sorter songSorter = new SongAcquisitionDateSort();
//        queryManager.setDatabase(personalLibrary);
//        queryManager.setSearcher(songTitleSearch);
//        queryManager.setSorter(songSorter);
//        queryManager.setArgument("");
//        printList(queryManager.executeQuery());




        // Save personalLibrary
        //personalLibrary.save();
    }
}
