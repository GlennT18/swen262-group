package view;

import java.util.*;

import controller.QueryManager;
import controller.sort.*;
import model.Release;
import model.Song;
import model.database.AllMusic;
import model.database.Database;
import model.database.PersonalMusicLibrary;
import controller.search.*;

public class CLI {
    static Scanner scanner = new Scanner(System.in);
    //creating the hashmap for each search
    private static HashMap<String, Searcher> artistSearches = new HashMap<String, Searcher>();
    private static HashMap<String, Searcher> releaseSearches = new HashMap<String, Searcher>();
    private static HashMap<String, Searcher> songSearches = new HashMap<String, Searcher>();

    public CLI(){
        //instantiate individual searches for artist
        artistSearches.put("name", new ArtistNameSearch());
        artistSearches.put("rating", new ArtistMinRatingSearch());
        artistSearches.put("type", new ArtistTypeSearch());

        //instantiate individual searches for releases
        releaseSearches.put("artistcode", new ReleaseArtistGuidSearch());
        releaseSearches.put("artistname", new ReleaseSongNameSearch());
        releaseSearches.put("maxduration", new ReleaseMaxDurationSearch());
        releaseSearches.put("minduration", new ReleaseMinDurationSearch());
        releaseSearches.put("minrating", new ReleaseMinRatingSearch());
        releaseSearches.put("songcode", new ReleaseSongGuidSearch());
        releaseSearches.put("songname", new ReleaseSongNameSearch());
        releaseSearches.put("title", new ReleaseTitleSearch());

        //instantiate individual searches for songs
        songSearches.put("artistcode", new SongArtistGuidSearch());
        songSearches.put("artistname", new SongArtistNameSearch());
        songSearches.put("maxduration", new SongMaxDurationSearch());
        songSearches.put("minduration", new SongMinDurationSearch());
        songSearches.put("minrating", new SongMinRatingSearch());
        songSearches.put("releasecode", new SongReleaseGuidSearch());
        songSearches.put("releasetitle", new SongReleaseTitleSearch());
        songSearches.put("title", new SongTitleSearch());
    }
    
    private static List<String> parseRequest(String request){
        if(request.equals("help")){
            System.out.println("In Muze Music Library System there are multiple ways to enter commands, but they must "
                    + "be very specific. There is room for five(5) words that need to be entered by the user. "
                    + "First, \nthe user will specify if they would like to search their personal music library or "
                    + "the total collection. This command will be \"personal\" or \"global\" respectively. "
                    + "The second command \nthe user will enter, decides what the user will be searching for. There are "
                    + "three options for this entry, \"artist\", \"release\", or \"song\". Finally, the user will enter "
                    + "a \nsearching arguement, these can be used by entering the following options:\nReleases\tArtist\t\tSong "
                    + "\nartistcode\tartistcode\tname\nartistname\tartistname\trating\nmaxduration\tmaxduration\ttype\n"
                    + "minduration\tminduration\nminrating\tminrating\nsongcode\treleasecode\nsongname\treleasetitle\n"
                    + "title\t\ttitle\n\nThe fourth(4th) word is only applicable if you are searching by the name/code/date "
                    + "of an artist or song. If thats the case, please enter the name/date accordingly. The fifth(5th) input "
                    + "will decide how the results are sorted. The options are as listed:\nRelease\t\tSong\tArtist\nAlphabetic\t"
                    + "Alphabetic\tAlphabetic\nRating\t\tRating\nAcquisition\tAcquisition\nReleaseDate\n\nPlease enter your command now: ");
            request = scanner.nextLine();
        }
        //parses string into char array
        String[] parsedList = request.split(",");
        for (int i=0; i < parsedList.length; i++) {
            parsedList[i] = parsedList[i].trim().toLowerCase();
        }

        return Arrays.asList(parsedList);
    }

    private static List findPersonalSearch(List command){
        Searcher activeSearch;
        List returns = new ArrayList<>();
        if(command.get(1).equals("artist")){
            //check which artist search to use
            if(command.get(2).equals("name")){
                activeSearch = artistSearches.get("name");
                returns.add(command.get(3));
            }else if(command.get(2).equals("rating")){
                activeSearch = artistSearches.get("rating");
                returns.add("rating");
            }else{
                activeSearch = artistSearches.get("type");
                returns.add(command.get(3));
            }
        }else if(command.get(1).equals("release")){
            //check which releases search to use
            if(command.get(2).equals("artistcode")){
                activeSearch = releaseSearches.get("artistcode");
                returns.add(command.get(3));
            }else if(command.get(2).equals("artistname")){
                activeSearch = releaseSearches.get("artistname");
                returns.add(command.get(3));
            }else if(command.get(2).equals("maxduration")){
                activeSearch = releaseSearches.get("maxduration");
                returns.add("maxduration");
            }else if(command.get(2).equals("minduration")){
                activeSearch = releaseSearches.get("minduration");
                returns.add("minduration");
            }else if(command.get(2).equals("songcode")){
                activeSearch = releaseSearches.get("songcode");
                returns.add(command.get(3));
            }else if(command.get(2).equals("songname")){
                activeSearch = releaseSearches.get("songname");
                returns.add(command.get(3));
            }else if(command.get(2).equals("minrating")){
                activeSearch = releaseSearches.get("minrating");
                returns.add("minrating");
            }else{
                activeSearch = releaseSearches.get("title");
                returns.add(command.get(3));
            }
        }else {
            //check which song search to use
            if (command.get(2).equals("artistcode")) {
                activeSearch = songSearches.get("artistcode");
                returns.add(command.get(3));
            } else if (command.get(2).equals("artistname")) {
                activeSearch = songSearches.get("artistname");
                returns.add(command.get(3));
            } else if (command.get(2).equals("maxduration")) {
                activeSearch = songSearches.get("maxduration");
                returns.add("maxduration");
            } else if (command.get(2).equals("minduration")) {
                activeSearch = songSearches.get("minduration");
                returns.add("minduration");
            } else if (command.get(2).equals("releasecode")) {
                activeSearch = songSearches.get("releasecode");
                returns.add(command.get(3));
            } else if (command.get(2).equals("releasetitle")) {
                activeSearch = songSearches.get("releasetitle");
                returns.add(command.get(3));
            } else if (command.get(2).equals("minrating")) {
                activeSearch = songSearches.get("minrating");
                returns.add("minrating");
            } else {
                activeSearch = songSearches.get("title");
                returns.add(command.get(3));
            }
        }
        returns.add(activeSearch);
        return returns;
    }

    private static List findGlobalSearch(List command){
        Searcher activeSearch;
        List returns = new ArrayList<>();
        if(command.get(1).equals("artist")){
            //check which artist search to use
            if(command.get(2).equals("name")){
                activeSearch = artistSearches.get("name");
                returns.add(command.get(3));
            }else{
                activeSearch = artistSearches.get("type");
                returns.add(command.get(3));
            }
        }else if(command.get(1).equals("release")){
            //check which releases search to use
            if(command.get(2).equals("artistcode")){
                activeSearch = releaseSearches.get("artistcode");
                returns.add(command.get(3));
            }else if(command.get(2).equals("artistname")){
                activeSearch = releaseSearches.get("artistname");
                returns.add(command.get(3));
            }else if(command.get(2).equals("maxduration")){
                activeSearch = releaseSearches.get("maxduration");
                returns.add("maxduration");
            }else if(command.get(2).equals("minduration")){
                activeSearch = releaseSearches.get("minduration");
                returns.add("minduration");
            }else if(command.get(2).equals("songcode")){
                activeSearch = releaseSearches.get("songcode");
                returns.add(command.get(3));
            }else if(command.get(2).equals("songname")){
                activeSearch = releaseSearches.get("songname");
                returns.add(command.get(3));
            }else{
                activeSearch = releaseSearches.get("title");
                returns.add(command.get(3));
            }
        }else{
            //check which song search to use
            if(command.get(2).equals("artistcode")){
                activeSearch = songSearches.get("artistcode");
                returns.add(command.get(3));
            }else if(command.get(2).equals("artistname")){
                activeSearch = songSearches.get("artistname");
                returns.add(command.get(3));
            }else if(command.get(2).equals("maxduration")){
                activeSearch = songSearches.get("maxduration");
                returns.add("maxduration");
            }else if(command.get(2).equals("minduration")){
                activeSearch = songSearches.get("minduration");
                returns.add("minduration");
            }else if(command.get(2).equals("releasecode")){
                activeSearch = songSearches.get("releasecode");
                returns.add(command.get(3));
            }else if(command.get(2).equals("releasetitle")){
                activeSearch = songSearches.get("releasetitle");
                returns.add(command.get(3));
            }else{
                activeSearch = songSearches.get("title");
                returns.add(command.get(3));
            }
        }
        returns.add(activeSearch);
        return returns;
    }

    public static Sorter findSort(List command){
        Sorter sort;
        if(command.get(1).equals("artist")){
            sort = new ArtistAlphaSort();
        }else if(command.get(1).equals("song")){
            if(command.get(4).equals("alphabetic")){
                sort = new SongAlphaSort();
            }else if(command.get(4).equals("rating")){
                sort = new SongRatingSort();
            }else{
                sort = new SongAcquisitionDateSort();
            }
        }else{
            if(command.get(4).equals("alphabetic")){
                sort = new ReleaseAlphaSort();
            }else if(command.get(4).equals("rating")){
                sort = new ReleaseRatingSort();
            }else if(command.get(4).equals("acquisition")){
                sort = new ReleaseAcquisitionDateSort();
            }else{
                sort = new ReleaseReleaseDateSort();
            }
        }
        return sort;
    }

    public static void addSong(List results, Database library){
        while(true){
            Song song;
            System.out.println("\nIf you would like to add a song to your playlist, please enter its numeric id here, if not, please enter \"end\": ");
            String stringID = scanner.nextLine();
            if(stringID.equals("end")){
                break;
            }else{
                int id = Integer.parseInt(stringID);
                song = (Song) results.get(id - 1);
                library.addSong(song);
            }
        }

    }

    public static void addRelease(List results, Database library){
        while(true) {
            Release release;
            System.out.println("\nIf you would like to add a release to your playlist, please enter its numeric id here, if not, please enter \"end\": ");
            String stringID = scanner.nextLine();
            if(stringID.equals("end")){
                break;
            }else{
                int id = Integer.parseInt(stringID);
                release = (Release) results.get(id - 1);
                library.addRelease(release);
            }
        }
    }

    public static void main(String args[]){
        //instantiates CLI, fills hashmaps with data
        CLI cli = new CLI();

        //creating the db for music & query manager
        Database allMusic = new AllMusic();
        Database personalLibrary = new PersonalMusicLibrary();
        QueryManager queryManager = new QueryManager();
        System.out.println("Welcome to The Muze Music Library System, enter \"help\" for controls");
        while(true){
            //introduces user
            System.out.print("Please enter command here: ");
            String request;
            List command = new ArrayList<>();


            request = scanner.nextLine();
            command = parseRequest(request);

            //gathers a correct command
            while(command == null){
                System.out.println("\n\nSorry, there was an error with you command. Please enter the data in a comma "
                        + "seperated list. Please type \"help\" to see examples.");
                System.out.println("Ex. \"global, artist, name, Bon Jovi\" Please re-enter now:");
                request = scanner.nextLine();
                command = parseRequest(request);
            }

            //bulk of cli

            //gathering arguements for the query manager
            List holder = new ArrayList<>();
            Searcher activeSearch;
            String type;
            if(command.get(0).equals("end")){
                System.out.println("Thank you for using The Muze Music Library!");
                System.exit(0);
            }
            Object arguement = command.get(3);
            if(command.get(0).equals("global")){
                holder = findGlobalSearch(command);
                queryManager.setDatabase(allMusic);
            }else{
                holder = findPersonalSearch(command);
                queryManager.setDatabase(personalLibrary);
            }
            type = (String) holder.get(0);
            activeSearch = (Searcher) holder.get(1);

            //developing the query manager
            Sorter sort = findSort(command);
            queryManager.setSearcher(activeSearch);
            queryManager.setArgument((String) arguement);
            queryManager.setSorter(sort);
            List temp = queryManager.executeQuery();
            int counter = 1;
            for(Object x : temp){
                System.out.println(counter + " : " + x);
                counter++;
            }

            if((command.get(1).equals("song")) && command.get(0).equals("global")){
                addSong(temp, personalLibrary);
            }else if((command.get(1).equals("release")) && command.get(0).equals("global")){
                addRelease(temp, personalLibrary);
            }else{
                continue;
            }

            counter = 0;
            System.out.println("Please enter another command: ");
        }

    }
}
