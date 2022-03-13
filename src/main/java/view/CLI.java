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
    HashMap<String, Searcher> artistSearches = new HashMap<String, Searcher>();
    HashMap<String, Searcher> releaseSearches = new HashMap<String, Searcher>();
    HashMap<String, Searcher> songSearches = new HashMap<String, Searcher>();
    public CLI(){
        //instantiate individual searches for artist
        artistSearches.put("name", new ArtistNameSearch());
        artistSearches.put("rating", new ArtistMinRatingSearch());
        artistSearches.put("rating", new ArtistMinRatingSearch());

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
    public static void main(String args[]){
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

        //checks length of arguements, and decids what search to use upon that information
        int arguements = command.size();

        //bulk of cli
        //creating the db for music & query manager
        Database allMusic = new AllMusic();
        Database personalLibrary = new PersonalMusicLibrary();
        QueryManager queryManager = new QueryManager();
    }
}
