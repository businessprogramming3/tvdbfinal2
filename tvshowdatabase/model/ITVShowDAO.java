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

    /**
     * creates a new record in table tvshow
     * @param show
     */
    void createRecord(TVShow show);
    
    /**
     * retrieves record in table tvshow by id
     * @param id
     */
    TVShow retrieveRecordById(int id);
    
    /**
     * retrieves record from table tvshow by name
     * @param name
     * @return tvshow
     */
    TVShow retrieveRecordByName(String name);
    
    /**
     * retrieves record from table tvshow by rating
     * @param rating
     * @return tvshow
     */
    List <TVShow> retrieveRecordsByRating(double rating);
    
    /**
     * retrieves record from table tvshow by actor
     * @param actor
     * @return tvshow
     */
    List <TVShow> retrieveRecordsByActor(String actor);
    
    /**
     * retrieves recrod from table tvshow by director
     * @param director
     * @return tvshow
     */
    List <TVShow> retrieveRecordsByDirector(String director);
    
    /**
     * retrieves record from table tvshow by genre
     * @param genre
     * @return tvshow
     */
    List <TVShow> retrieveRecordsByGenre(String genre);
    
    /**
     * retrieves every record in table tvshow
     * @return tvshow
     */
    List<TVShow> retrieveAllRecords();
    
    /**
     * updates a record in table tvshow
     * @param updatedShow
     */
    void updateRecord(TVShow updatedShow);
    
    /**
     * deletes a record in table tvshow by id
     * @param id
     */
    void deleteRecord(int id);
    
    /**
     * deletes a record in table tvshow 
     * @param show
     */
    void deleteRecord(TVShow show);
}
