//Når vi skal bruge Song i main skal vi importerer den: import Model.SongHandler.Song;
package Model.SongHandler;

//Klasse, som repræsenterer én sang
public class Song {
    //Instansvariablerne som gemmer data for en sang
    //Private = kun Song-klassen må direkte ændre dem(encapsulation)
    private String title;
    private Genre genre;
    private String artist;

    public Song(String title, Genre genre, String artist){
       //Constructor - kører når vi laver new song
        this.title = title;
        this.genre = genre;
        this.artist = artist;
    }

    //Getters og sætters så andre klasser får adgang til dem og redigere dem.
    public String getTitle(){
        return title;
    }
    public void setTitle(String newTitle){
        this.title = newTitle;
    }
    public Genre getGenre(){
        return genre;
    }
    public void setGenre(Genre genre){
        this.genre = genre;
    }
    public String getArtist(){
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String formatForPlayList() {

        // Example of behavior specific to liquids
        /*if (getUnit() == Unit.ML && getAmount() >= 1000) {
            return getName() + " - " + (getAmount() / 1000) + " L";
        }*/

        return getTitle() + " - " + getGenre() + " " + getArtist();
    }
        @Override
                public String toString(){
            return title + " - " + artist + " (" + genre + ")";
        }
    }

