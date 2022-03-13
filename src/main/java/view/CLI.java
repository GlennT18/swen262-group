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

    private static List findPersonalSearch(List command){
        Searcher activeSearch;
        List returns = new ArrayList<>();
        if(command.get(1).equals("artist")){
            //check which artist search to use
            if(command.get(2).equals("name")){
                activeSearch = artistSearches.get("name");
                returns.add("name");
            }else if(command.get(2).equals("rating")){
                activeSearch = artistSearches.get("rating");
                returns.add("rating");
            }else{
                activeSearch = artistSearches.get("type");
                returns.add("type");
            }
        }else if(command.get(1) == "release"){
            //check which releases search to use
            if(command.get(2).equals("artistcode")){
                activeSearch = releaseSearches.get("artistcode");
                returns.add("artistcode");
            }else if(command.get(2).equals("artistname")){
                activeSearch = releaseSearches.get("artistname");
                returns.add("artistname");
            }else if(command.get(2).equals("maxduration")){
                activeSearch = releaseSearches.get("maxduration");
                returns.add("maxduration");
            }else if(command.get(2).equals("minduration")){
                activeSearch = releaseSearches.get("minduration");
                returns.add("minduration");
            }else if(command.get(2).equals("songcode")){
                activeSearch = releaseSearches.get("songcode");
                returns.add("songcode");
            }else if(command.get(2).equals("songname")){
                activeSearch = releaseSearches.get("songname");
                returns.add("songname");
            }else if(command.get(2).equals("minrating")){
                activeSearch = releaseSearches.get("minrating");
                returns.add("minrating");
            }else{
                activeSearch = releaseSearches.get("title");
                returns.add("title");
            }
        }else {
            //check which song search to use
            if (command.get(2).equals("artistcode")) {
                activeSearch = songSearches.get("artistcode");
                returns.add("artistcode");
            } else if (command.get(2).equals("artistname")) {
                activeSearch = songSearches.get("artistname");
                returns.add("artistname");
            } else if (command.get(2).equals("maxduration")) {
                activeSearch = songSearches.get("maxduration");
                returns.add("maxduration");
            } else if (command.get(2).equals("minduration")) {
                activeSearch = songSearches.get("minduration");
                returns.add("minduration");
            } else if (command.get(2).equals("releasecode")) {
                activeSearch = songSearches.get("releasecode");
                returns.add("releasecode");
            } else if (command.get(2).equals("releasetitle")) {
                activeSearch = songSearches.get("releasetitle");
                returns.add("releasetitle");
            } else if (command.get(2).equals("minrating")) {
                activeSearch = songSearches.get("minrating");
                returns.add("minrating");
            } else {
                activeSearch = songSearches.get("title");
                returns.add("title");
            }
        }
        returns.add(activeSearch);
        return returns;
    }

    private static List findGlobalSearch(List command){
        Searcher activeSearch;
        List returns = new ArrayList<>();
        if(command.get(1) == "artist"){
            //check which artist search to use
            if(command.get(2).equals("name")){
                activeSearch = artistSearches.get("name");
                returns.add("name");
            }else{
                activeSearch = artistSearches.get("type");
                returns.add("type");
            }
        }else if(command.get(1) == "release"){
            //check which releases search to use
            if(command.get(2).equals("artistcode")){
                activeSearch = releaseSearches.get("artistcode");
                returns.add("artistcode");
            }else if(command.get(2).equals("artistname")){
                activeSearch = releaseSearches.get("artistname");
                returns.add("artistname");
            }else if(command.get(2).equals("maxduration")){
                activeSearch = releaseSearches.get("maxduration");
                returns.add("maxduration");
            }else if(command.get(2).equals("minduration")){
                activeSearch = releaseSearches.get("minduration");
                returns.add("minduration");
            }else if(command.get(2).equals("songcode")){
                activeSearch = releaseSearches.get("songcode");
                returns.add("songcode");
            }else if(command.get(2).equals("songname")){
                activeSearch = releaseSearches.get("songname");
                returns.add("songname");
            }else{
                activeSearch = releaseSearches.get("title");
                returns.add("title");
            }
        }else{
            //check which song search to use
            if(command.get(2).equals("artistcode")){
                activeSearch = songSearches.get("artistcode");
                returns.add("artistcode");
            }else if(command.get(2).equals("artistname")){
                activeSearch = songSearches.get("artistname");
                returns.add("artistname");
            }else if(command.get(2).equals("maxduration")){
                activeSearch = songSearches.get("maxduration");
                returns.add("maxduration");
            }else if(command.get(2).equals("minduration")){
                activeSearch = songSearches.get("minduration");
                returns.add("minduration");
            }else if(command.get(2).equals("releasecode")){
                activeSearch = songSearches.get("releasecode");
                returns.add("releasecode");
            }else if(command.get(2).equals("releasetitle")){
                activeSearch = songSearches.get("releasetitle");
                returns.add("releasetitle");
            }else{
                activeSearch = songSearches.get("title");
                returns.add("title");
            }
        }
        returns.add(activeSearch);
        return returns;
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

        //gathering arguements for the query manager
        List holder = new ArrayList<>();
        Searcher activeSearch;
        String arguement;
        if(command.get(0).equals("global")){
            holder = findGlobalSearch(command);
            queryManager.setDatabase(allMusic);
        }else{
            holder = findPersonalSearch(command);
            queryManager.setDatabase(personalLibrary);
        }
        arguement = (String) holder.get(0);
        activeSearch = (Searcher) holder.get(1);

        //developing the query manager
        queryManager.setSearcher(activeSearch);
        queryManager.setArgument(arguement);
    }
}
