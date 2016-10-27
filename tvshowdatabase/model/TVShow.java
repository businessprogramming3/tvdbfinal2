
package tvshowdatabase.model;

public class TVShow {
    private int id;
    private double rating;
    private int seasons;
    private String name;
    private String genre;
    private String director;
    private String mainActor;
    
    public TVShow(){
        id = 0;
        rating = 0.0;
        seasons = 0;
        name = "";
        genre = ""; 
        director = "";
        mainActor = ""; 
    }
    
    public TVShow(int id, double rating, int seasons, String name, String genre, String director, String mainActor){
     this.id = id;
     this.rating = rating;
     this.seasons = seasons;
     this.name = name;
     this.genre = genre;
     this.director = director;
     this.mainActor = mainActor;  
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMainActor() {
        return mainActor;
    }

    public void setMainActor(String mainActor) {
        this.mainActor = mainActor;
    }

    @Override
    public String toString() {
        return "TVShow{" + "id=" + id + ", rating=" + rating + ", seasons=" + seasons + ", name=" + name + ", genre=" + genre + ", director=" + director + ", mainActor=" + mainActor + '}';
    }
    
    
}
