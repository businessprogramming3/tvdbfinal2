/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvshowdatabase.model;
import java.util.List;
/**
 *
 * @author river
 */
public interface ITVShowDAO {
    void createRecord(TVShow show);
    
    TVShow retrieveRecordById(int id);
    
    TVShow retrieveRecordByName(String name);
    
    List <TVShow> retrieveRecordsByRating(double rating);
    
    List <TVShow> retrieveRecordsByActor(String actor);
    
    List <TVShow> retrieveRecordsByDirector(String director);
    
    List <TVShow> retrieveRecordsByGenre(String genre);
    
    List<TVShow> retrieveAllRecords();
    
    void updateRecord(TVShow updatedShow);
    
    void deleteRecord(int id);
    
    void deleteRecord(TVShow show);
}
