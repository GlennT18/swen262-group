import controller.QueryManager;
import controller.search.ArtistNameSearch;
import controller.search.ArtistTypeSearch;
import controller.search.Searcher;
import model.Release;
import model.database.AllMusic;
import model.database.Database;
import model.database.PersonalMusicLibrary;

import java.util.List;

public class Application {
    public static void printList(List list) {
        System.out.println("[");
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println("]");
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



        // Save personalLibrary
        personalLibrary.save();
    }
}
