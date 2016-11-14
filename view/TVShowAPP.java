
package view;
import tvshowdatabase.model.ITVShowDAO;
import tvshowdatabase.model.TVShow;
import tvshowdatabase.model.datastore.TVShowDAO;
import utility.Validator;
import java.sql.*;

import java.util.Scanner;
public class TVShowAPP {
    ITVShowDAO showList = new TVShowDAO();
    Scanner scan = new Scanner(System.in);
    
public TVShowAPP(){
    menu();
}
    
private void menu(){
    int id, seasons;
    double rating;
    String name, genre, director, mainActor;
    String choice = "1";
    while(!choice.equals("0")){
        System.out.println("TVSHOW APP");
        System.out.println("0 = QUIT");
        System.out.println("1 = LIST ALL RECORDS");
        System.out.println("2 = CREATE NEW RECORD");
        System.out.println("3 = RETRIEVE RECORD BY ID");
        System.out.println("4 = RETRIEVE RECORD BY NAME");
        System.out.println("5 = RETRIEVE RECORD BY GENRE");
        System.out.println("6 = RETRIEVE RECORD BY RATING");
        System.out.println("7 = RETRIEVE RECORD BY DIRECTOR");
        System.out.println("8 = RETRIEVE RECORD BY ACTOR");
        System.out.println("9 = UPDATE RECORD");
        System.out.println("10 = DELETE RECORD");
        choice = Validator.getLine(scan, "NUMBER OF CHOICE: ", "\\d+$");
            
        switch(choice){
            case "1": //list all records
                System.out.println(showList.toString());
                break;
            case "2": //create new record
                id = Validator.getInt(scan, "NEW TV SHOW ID: ");
                rating = Validator.getDouble(scan, "NEW RATING: ");
                seasons = Validator.getInt(scan, "NEW NUMBER OF SEASONS: ");
                name = Validator.getLine(scan, "NEW NAME: ");
                genre = Validator.getLine(scan, "NEW GENRE: ");
                director = Validator.getLine(scan, "NEW DIRECTOR: ");
                mainActor = Validator.getLine(scan, "NEW MAIN ACTOR: ");
                    
                showList.createRecord(new TVShow(id, rating, seasons, name, genre, director, mainActor));
                break;
            case "3": //retrieve record by id
                id = Validator.getInt(scan, "TV SHOW ID TO RETRIEVE: ");
                System.out.println(showList.retrieveRecordById(id));
                break;
            case "4"://retrieve record by name
                name = Validator.getLine(scan, "TV SHOW NAME TO RETRIEVE: ");
                System.out.println(showList.retrieveRecordByName(name));
                break;
            case "5"://retrieve record by genre
                genre = Validator.getLine(scan, "GENRE OF SHOWS TO RETRIEVE: ");
                System.out.println(showList.retrieveRecordsByGenre(genre));
                break;
            case "6"://retrieve records by rating
                rating = Validator.getDouble(scan, "RATING OF SHOWS TO RETRIEVE: ");
                System.out.println(showList.retrieveRecordsByRating(rating));
                break;
            case "7"://retrieve records by director
                director = Validator.getLine(scan, "DIRECTOR OF SHOWS TO RETRIEVE: ");
                System.out.println(showList.retrieveRecordsByDirector(director));
                break;
            case "8"://retrieve records by actor
                mainActor = Validator.getLine(scan, "ACTOR OF SHOWS TO RETRIEVE: ");
                System.out.println(showList.retrieveRecordsByActor(mainActor));
                break;
            case "9"://update record
                id = Validator.getInt(scan, "TVSHOW ID TO UPDATE: ");
                rating = Validator.getDouble(scan, "UPDATED RATING: ");
                seasons = Validator.getInt(scan, "UPDATED NUMBER OF SEASONS: ");
                name = Validator.getLine(scan, "UPDATED NAME: ");
                genre = Validator.getLine(scan, "UPDATED GENRE: ");
                director = Validator.getLine(scan, "UPDATED DIRECTOR: ");
                mainActor = Validator.getLine(scan, "UPDATED MAIN ACTOR: ");
                showList.updateRecord(new TVShow(id, rating, seasons, name, genre, director, mainActor));
                break;
            case "10"://delete record
                id = Validator.getInt(scan, "ENTER ID OF TV SHOW TO DELETE: ");
                System.out.println(showList.retrieveRecordById(id));
                String ok = Validator.getLine(scan, "DELETE? (y/n): ", "^[yYnN]$");
                if(ok.equalsIgnoreCase("y")){
                    showList.deleteRecord(id);
                }
                break;
        }
    }  
}

public static void main(String[] args){
    new TVShowAPP();
}
    
}
