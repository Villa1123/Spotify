//Samme package som Song, så PlayList kan bruge Song uden import
package Model.SongHandler;
//Importerer ArrayList, som er listen vi gemmer sange i
import java.util.ArrayList;
public class PlayList {
    //Laver en liste der kan indeholde Song objekter. Starter tom
    private ArrayList<Song> songs = new ArrayList<>();

    //Getter, der giveer adgang til hele listen.
    //Repo kan bruge getSongs() for at gemme alle sange
    public ArrayList<Song> getSongs() {
        return songs;
    }

    //Metode deer tilføjer sang til playlisten
    public void addSong(Song s) {
        songs.add(s);
    }

    //Metode, der prøver at fjerne en sang ud fra titel.
    //Returnerer true hvis den fandt og fjernede, ellers false.
    public boolean removeByTitle(String title) {
        //For Loop over listen med index
        for (int i = 0; i < songs.size(); i++) {
            //Tjekker om titlen matcher(case-sensitivity/validation)
            if (songs.get(i).getTitle().equalsIgnoreCase(title)) {
              //Fjerner sangen
                songs.remove(i);
                return true;
            }
        }
        return false;
    }

    //Finder først sang med matchende titel
    //Returnerer selve Song-objekter eller null
    public Song findFirstByTitle(String title) {
       //For-each loop gennem listen. Ellers null
        for (Song s : songs) {
            if (s.getTitle().equalsIgnoreCase(title)) {
                return s;
            }
        }
        return null;
    }
//Udskriver alle sange direkte
    public void showAll() {
        //Hvis listen er tom -> besked og stop
        if (songs.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        //Printer hver sang
        //songs.get(i) bliver automatisk til tekst via toString()
        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i + 1) + ". " + songs.get(i));
        }
    }
}
