
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
        System.out.println("5 = UPDATE RECORD");
        System.out.println("6 = DELETE RECORD");
        choice = Validator.getLine(scan, "NUMBER OF CHOICE: ", "[0-6]$");
            
        switch(choice){
            case "1":
                System.out.println(showList.toString());
                break;
            case "2":
                id = Validator.getInt(scan, "NEW TV SHOW ID: ");
                rating = Validator.getDouble(scan, "NEW RATING: ");
                seasons = Validator.getInt(scan, "NEW NUMBER OF SEASONS: ");
                name = Validator.getLine(scan, "NEW NAME: ");
                genre = Validator.getLine(scan, "NEW GENRE: ");
                director = Validator.getLine(scan, "NEW DIRECTOR: ");
                mainActor = Validator.getLine(scan, "NEW MAIN ACTOR: ");
                    
                showList.createRecord(new TVShow(id, rating, seasons, name, genre, director, mainActor));
                break;
            case "3":
                id = Validator.getInt(scan, "TV SHOW ID TO RETRIEVE: ");
                System.out.println(showList.retrieveRecordById(id));
                break;
            case "4":
                name = Validator.getLine(scan, "TV SHOW NAME TO RETRIEVE: ");
                System.out.println(showList.retrieveRecordByName(name));
                break;
            case "5": 
                id = Validator.getInt(scan, "TVSHOW ID TO UPDATE: ");
                rating = Validator.getDouble(scan, "UPDATED RATING: ");
                seasons = Validator.getInt(scan, "UPDATED NUMBER OF SEASONS: ");
                name = Validator.getLine(scan, "UPDATED NAME: ");
                genre = Validator.getLine(scan, "UPDATED GENRE: ");
                director = Validator.getLine(scan, "UPDATED DIRECTOR: ");
                mainActor = Validator.getLine(scan, "UPDATED MAIN ACTOR: ");
                showList.updateRecord(new TVShow(id, rating, seasons, name, genre, director, mainActor));
                break;
            case "6":
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
