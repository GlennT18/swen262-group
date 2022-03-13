package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLI {
    static Scanner scanner = new Scanner(System.in);
    
    private static List parseRequest(String request){
        char[] characters = request.toCharArray();
        List parsedList = new ArrayList<>();
        String keyword = "";
        for(char character : characters){
            //also needs to check if character is symbol
            if(Character.isDigit(character)){
                return null;
            }
            if(character == ','){
                parsedList.add(keyword);
                keyword = "";
            }else if(character == ' '){
                continue;
            }else{
                keyword += character;
            }
        }
        parsedList.add(keyword);
        return parsedList;
    }
    public static void main(String args[]){
        String request;
        List command = new ArrayList<>();
        System.out.println("Welcome to The Muze Music Library System\nPlease enter your command(s) here as a comma seperated list: ");
        request = scanner.nextLine();
        command = parseRequest(request);
        while(command == null){
            System.out.println("\n\nSorry, there was an error with you command. Please enter the data in a comma seperated list");
            System.out.println("Ex. \"song, artist, release\" Please re-enter now:");
            request = scanner.nextLine();
            command = parseRequest(request);
        }
        System.out.println(command);
    }
}
