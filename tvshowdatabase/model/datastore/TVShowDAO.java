
package tvshowdatabase.model.datastore;




import tvshowdatabase.model.TVShow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import tvshowdatabase.model.datastore.DBConnection;
import tvshowdatabase.model.ITVShowDAO;

public class TVShowDAO implements ITVShowDAO {

    protected final static boolean DEBUG = true;
	
	public void createRecord(TVShow show){
		final String QUERY = "insert into tvshow "
				+ "(id, rating, seasons, name, genre, director, actor)" 
				+ "VALUES (null, ?, ?, ?, ?, ?, ?)";
		
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(QUERY);){
                        stmt.setDouble(1, show.getRating());
			stmt.setInt(2, show.getSeasons());
			stmt.setString(3, show.getName());
                        stmt.setString(4, show.getGenre());
			stmt.setString(5, show.getDirector());
			stmt.setString(6, show.getMainActor());
			if (DEBUG) {
				System.out.println(stmt.toString());
			}
			stmt.executeUpdate();
			
		} catch (SQLException ex){
			System.out.println("createRecord SQLException: " + ex.getMessage());
		}
	}
	
	public TVShow retrieveRecordById(int id) {
		final String QUERY = "select id, rating, seasons, name, genre, director, actor " 
				+ "from tvshow where id = " + id;
		
		TVShow show = null;
		
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(QUERY)){
			if (DEBUG) {
				System.out.println(stmt.toString());
			}
			ResultSet rs = stmt.executeQuery(QUERY);
			
			if (rs.next()){
				show = new TVShow(
						rs.getInt("id"),
						rs.getDouble("rating"),
						rs.getInt("seasons"), 
						rs.getString("name"),
                                                rs.getString("genre"),
						rs.getString("director"),
						rs.getString("actor"));
			}
		}catch (SQLException ex) {
			System.out.println("retrieveRecordById SQLException: " + ex.getMessage());
		}
		
		return show;
	}
	
	public List<TVShow> retrieveAllRecords(){
		final List<TVShow> myList = new ArrayList<>();
		final String QUERY = "select id, rating, seasons, name, genre, director, actor from tvshow";
		
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(QUERY)){
			if (DEBUG){
				System.out.println(stmt.toString());
			}
			ResultSet rs = stmt.executeQuery(QUERY);
			
			while(rs.next()){
				myList.add(new TVShow(
						rs.getInt("id"),
						rs.getDouble("rating"),
						rs.getInt("seasons"),
						rs.getString("name"),
                                                rs.getString("genre"),
						rs.getString("director"),
						rs.getString("actor")));
				
			}
		} catch (SQLException ex){
			System.out.println("retrieveAllRecords SQLException: " + ex.getMessage());
		}
		return myList;
	}
	
	public TVShow retrieveRecordByName(String name){
            final String QUERY = "select id, rating, seasons, name, genre, "
                        + "director, actor from tvshow where name = " + "\"" + name + "\"";
		
		TVShow show = null;
		
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(QUERY)){
			if(DEBUG){
				System.out.println(stmt.toString());
			}
			ResultSet rs = stmt.executeQuery(QUERY);
			
			while (rs.next()){
				show = new TVShow(
						rs.getInt("id"),
						rs.getDouble("rating"),
						rs.getInt("seasons"),
						rs.getString("name"),
                                                rs.getString("genre"),
						rs.getString("director"),
						rs.getString("actor"));						
			}
		} catch (SQLException ex){
			System.out.println("retrieveRecordByName SQLException: " + ex.getMessage());
		}
		
		return show;
	}
        
        public List<TVShow> retrieveRecordsByRating(double rating){
            //Alyssa
            final List<TVShow> myList = new ArrayList<>();
            final String QUERY = "select id, rating, seasons, name, genre, "
                    + "director, actor from tvshow where rating = " + rating;
            
            try(Connection con = DBConnection.getConnection();
                    PreparedStatement stmt = con.prepareStatement(QUERY)){
                if(DEBUG){
                    System.out.println(stmt.toString());
                }
                ResultSet rs = stmt.executeQuery(QUERY);
                
                while(rs.next()){
                    myList.add(new TVShow(
                        rs.getInt("id"),
                        rs.getDouble("rating"),
                        rs.getInt("seasons"),
                        rs.getString("name"),
                        rs.getString("genre"),
                        rs.getString("director"),
                        rs.getString("actor")));
                }
            }catch(SQLException ex){
                System.out.println("retrieveRecordsByRating SQLException: " + ex.getMessage());
            }
            return myList;
        }

        public List <TVShow> retrieveRecordsByDirector(String director){
            //Jacques
                final List<TVShow> myList = new ArrayList<>();
            final String QUERY = "select id, rating, seasons, name, genre, "
                    + "director, actor from tvshow where director = " + "\"" + director + "\"";
            
            try(Connection con = DBConnection.getConnection();
                    PreparedStatement stmt = con.prepareStatement(QUERY)){
                if(DEBUG){
                    System.out.println(stmt.toString());
                }
                ResultSet rs = stmt.executeQuery(QUERY);
                
                while(rs.next()){
                    myList.add(new TVShow(
                        rs.getInt("id"),
                        rs.getDouble("rating"),
                        rs.getInt("seasons"),
                        rs.getString("name"),
                        rs.getString("genre"),
                        rs.getString("director"),
                        rs.getString("actor")));
                }
            }catch(SQLException ex){
                System.out.println("retrieveRecordsByDirector SQLException: " + ex.getMessage());
            }
            return myList;
          
        }
        
        public List <TVShow> retrieveRecordsByActor(String actor){
            //Jessica
            final List<TVShow> myList = new ArrayList<>();
            final String QUERY = "select id, rating, seasons, name, genre, "
                    + "director, actor from tvshow where actor = " + "\"" + actor + "\"";
            
            try(Connection con = DBConnection.getConnection();
                    PreparedStatement stmt = con.prepareStatement(QUERY)){
                if(DEBUG){
                    System.out.println(stmt.toString());
                }
                ResultSet rs = stmt.executeQuery(QUERY);
                
                while(rs.next()){
                    myList.add(new TVShow(
                        rs.getInt("id"),
                        rs.getDouble("rating"),
                        rs.getInt("seasons"),
                        rs.getString("name"),
                        rs.getString("genre"),
                        rs.getString("director"),
                        rs.getString("actor")));
                }
            }catch(SQLException ex){
                System.out.println("retrieveRecordsByActor SQLException: " + ex.getMessage());
            }
            return myList;
        }
        
        public List <TVShow> retrieveRecordsByGenre(String genre){
            //Zachary
            final List<TVShow> myList = new ArrayList<>();
            final String QUERY = "select id, rating, seasons, name, genre, "
                    + "director, actor from tvshow where genre = " + "\"" + genre + "\"";
            
            try(Connection con = DBConnection.getConnection();
                    PreparedStatement stmt = con.prepareStatement(QUERY)){
                if(DEBUG){
                    System.out.println(stmt.toString());
                }
                ResultSet rs = stmt.executeQuery(QUERY);
                
                while(rs.next()){
                    myList.add(new TVShow(
                        rs.getInt("id"),
                        rs.getDouble("rating"),
                        rs.getInt("seasons"),
                        rs.getString("name"),
                        rs.getString("genre"),
                        rs.getString("director"),
                        rs.getString("actor")));
                }
            }catch(SQLException ex){
                System.out.println("retrieveRecordsByGenre SQLException: " + ex.getMessage());
            }
            return myList;
        }
        
	public void updateRecord(TVShow updatedShow){
		final String QUERY = "update tvshow set rating=?, seasons=?, name=?, genre=?, director=?, "
                        + "actor=? where id=?";
		
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(QUERY)){
				stmt.setDouble(1, updatedShow.getRating());
				stmt.setInt(2, updatedShow.getSeasons());
				stmt.setString(3, updatedShow.getName());
                                stmt.setString(4, updatedShow.getGenre());
				stmt.setString(5, updatedShow.getDirector());
				stmt.setString(6, updatedShow.getMainActor());
                                stmt.setInt(7, updatedShow.getId());
				if(DEBUG){
					System.out.println(stmt.toString());
				}
				stmt.executeUpdate();
		} catch (SQLException ex){
			System.out.println("updateRecord SQLException: " + ex.getMessage());
		}
	}
	
	public void deleteRecord(int id){
		final String QUERY = "delete from tvshow where id=?";
		
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(QUERY)){
			stmt.setInt(1, id);
			if (DEBUG){
				System.out.println(stmt.toString());
			}
			stmt.executeUpdate();
		} catch(SQLException ex){
			System.out.println("deleteRecord SQLException: " + ex.getMessage());
		}
	}
	
	public void deleteRecord(TVShow show){
		final String QUERY = "delete from tvshow where show = ?";
		
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(QUERY)){
			stmt.setInt(1, show.getId());
			if (DEBUG){
				System.out.println(stmt.toString());
			}
			stmt.executeUpdate();
		} catch (SQLException ex){
			System.out.println("deleteRecord SQLException: " + ex.getMessage());
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(TVShow show : retrieveAllRecords()){
			sb.append(show.toString()).append("\n");
		}
		return sb.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
