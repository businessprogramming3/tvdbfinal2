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
    
    List<TVShow> retrieveAllRecords();
    
    void updateRecord(TVShow updatedShow);
    
    void deleteRecord(int id);
    
    void deleteRecord(TVShow show);
}
