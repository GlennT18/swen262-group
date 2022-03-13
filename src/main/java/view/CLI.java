package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import controller.QueryManager;
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
    
    private static List parseRequest(String request){
        //parses string into char array
        request = request.replaceAll("\\s", "");
        request = request.toLowerCase();
        char[] characters = request.toCharArray();
        List parsedList = new ArrayList<>();
        String keyword = "";
        for(char character : characters){   
            String temp = Character.toString(character);
            if(!(temp.matches("^[A-Za-z0-9,/]"))){
                //checks if char is a digit or special symbol
                System.out.println("\nDo not include symbols or digits in your command");
                return null;
            }
            if(character == ','){
                //if char is a comma, the word that has been compiled is put into the words list
                //sets keyword back to blank
                parsedList.add(keyword);
                keyword = "";
            }else{
                //if the character is valid, it is appended to the keyword
                keyword += character;
            }
        }
        //adds last word and returns the list of words
        parsedList.add(keyword);
        return parsedList;
    }

    private static Searcher findPersonalSearch(List command){
        Searcher activeSearch;
        if(command.get(1) == "artist"){
            //check which artist search to use
            if(command.get(2) == "name"){
                activeSearch = artistSearches.get("name");
            }else if(command.get(2) == "rating"){
                activeSearch = artistSearches.get("rating");
            }else{
                activeSearch = artistSearches.get("type");
            }
        }else if(command.get(1) == "release"){
            //check which releases search to use
            if(command.get(2) == "artistcode"){
                activeSearch = releaseSearches.get("artistcode");
            }else if(command.get(2) == "artistname"){
                activeSearch = releaseSearches.get("artistname");
            }else if(command.get(2) == "maxduration"){
                activeSearch = releaseSearches.get("maxduration");
            }else if(command.get(2) == "minduration"){
                activeSearch = releaseSearches.get("minduration");
            }else if(command.get(2) == "songcode"){
                activeSearch = releaseSearches.get("songcode");
            }else if(command.get(2) == "songname"){
                activeSearch = releaseSearches.get("songname");
            }else if(command.get(2) == "minrating"){
                activeSearch = releaseSearches.get("minrating");
            }else{
                activeSearch = releaseSearches.get("title");
            }
        }else {
            //check which song search to use
            if (command.get(2) == "artistcode") {
                activeSearch = songSearches.get("artistcode");
            } else if (command.get(2) == "artistname") {
                activeSearch = songSearches.get("artistname");
            } else if (command.get(2) == "maxduration") {
                activeSearch = songSearches.get("maxduration");
            } else if (command.get(2) == "minduration") {
                activeSearch = songSearches.get("minduration");
            } else if (command.get(2) == "releasecode") {
                activeSearch = songSearches.get("releasecode");
            } else if (command.get(2) == "releasetitle") {
                activeSearch = songSearches.get("releasetitle");
            } else if (command.get(2) == "minrating") {
                activeSearch = songSearches.get("minrating");
            } else {
                activeSearch = songSearches.get("title");
            }
        }
        return  activeSearch;
    }

    private static Searcher findGlobalSearch(List command){
        Searcher activeSearch;
        if(command.get(1) == "artist"){
            //check which artist search to use
            if(command.get(2) == "name"){
                activeSearch = artistSearches.get("name");
            }else{
                activeSearch = artistSearches.get("type");
            }
        }else if(command.get(1) == "release"){
            //check which releases search to use
            if(command.get(2) == "artistcode"){
                activeSearch = releaseSearches.get("artistcode");
            }else if(command.get(2) == "artistname"){
                activeSearch = releaseSearches.get("artistname");
            }else if(command.get(2) == "maxduration"){
                activeSearch = releaseSearches.get("maxduration");
            }else if(command.get(2) == "minduration"){
                activeSearch = releaseSearches.get("minduration");
            }else if(command.get(2) == "songcode"){
                activeSearch = releaseSearches.get("songcode");
            }else if(command.get(2) == "songname"){
                activeSearch = releaseSearches.get("songname");
            }else{
                activeSearch = releaseSearches.get("title");
            }
        }else{
            //check which song search to use
            if(command.get(2) == "artistcode"){
                activeSearch = songSearches.get("artistcode");
            }else if(command.get(2) == "artistname"){
                activeSearch = songSearches.get("artistname");
            }else if(command.get(2) == "maxduration"){
                activeSearch = songSearches.get("maxduration");
            }else if(command.get(2) == "minduration"){
                activeSearch = songSearches.get("minduration");
            }else if(command.get(2) == "releasecode"){
                activeSearch = songSearches.get("releasecode");
            }else if(command.get(2) == "releasetitle"){
                activeSearch = songSearches.get("releasetitle");
            }else{
                activeSearch = songSearches.get("title");
            }
        }
        return activeSearch;
    }

    public static void main(String args[]){
        //instantiates CLI, fills hashmaps with data
        CLI cli = new CLI();

        //introduces user
        String request;
        List command = new ArrayList<>();
        System.out.println("Welcome to The Muze Music Library System\nPlease enter your command(s) here as a comma seperated list: ");
        request = scanner.nextLine();
        command = parseRequest(request);

        //gathers a correct command
        while(command == null){
            System.out.println("\n\nSorry, there was an error with you command. Please enter the data in a comma seperated list");
            System.out.println("Ex. \"song, artist, release\" Please re-enter now:");
            request = scanner.nextLine();
            command = parseRequest(request);
        }

        //bulk of cli
        //creating the db for music & query manager
        Database allMusic = new AllMusic();
        Database personalLibrary = new PersonalMusicLibrary();
        QueryManager queryManager = new QueryManager();
        Searcher activeSearch;
        if(command.get(0) == "global"){
            activeSearch = findGlobalSearch(command);
            //setting the search in the query
            queryManager.setSearcher(activeSearch);
            //setting the db in query
            queryManager.setDatabase(allMusic);
        }else{
            activeSearch = findPersonalSearch(command);
        }
    }
}
